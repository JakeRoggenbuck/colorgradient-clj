(ns colorgradient-clj.core)

(defn roughly-equal [a b]
  (and (< -0.0000000001 (- a b)) (< (- a b) 0.0000000001)))

(defn find-slope [x1 y1 x2 y2]
  (/ (- y2 y1) (- x2 x1)))

(defn trunc [x]
  (+ 0.0 (with-precision 1 :rounding DOWN
    (* 1M (bigdec x)))))

(defn fract [x]
  (- x (trunc x)))

(defn find-y [x known-x]
  (if (== (fract x) 0)
    (get known-x x)
    ((def left-x (trunc x))
     (def right-x (+ left-x 1))
     (def left-y (get known-x left-x))
     (def right-y (get known-x right-x))

     (def slope (find-slope left-x left-y right-x right-y))

     (+ left-y (* slope (- x left-x))))))
