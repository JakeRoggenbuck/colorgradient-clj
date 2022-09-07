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
