(ns colorgradient-clj.core-test
  (:require [clojure.test :refer :all]
            [colorgradient-clj.core :refer :all]))

(deftest roughly-equal-test
  (testing "Pass one"
    (is (roughly-equal 0.12300000000000022 0.123))))

(deftest find-slope-test
  (testing "Pass one"
    (is (= 1.0 (find-slope 1.0 2.0 3.0 4.0)))
    (is (= 0.5 (find-slope 0.0 1.0 2.0 2.0)))
    (is (= 0.75 (find-slope 0.0 2.0 4.0 5.0)))
    (is (= 0.3333333333333333 (find-slope -2.0 1.0 1.0 2.0)))))

(deftest trunc-test
  (testing "Pass one"
    (is (= 1.0 (trunc 1.3442)))))

(deftest fract-test
  (testing "Pass one"
    (is (= 0.12300000000000022 (fract 2.123)))))
