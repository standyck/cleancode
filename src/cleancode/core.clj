(ns cleancode.core
  (:require [clojure.string :as str]))

;;; This is an incorrect implementation, such as might be written by
;;; someone who was used to a Lisp in which an empty list is equal to
;;; nil.
(defn first-element [sequence default]
  (if (nil? sequence)
    default
    (first sequence)))

(defn format [msg expected actual]
  (str/trim (str msg " expected:<[" expected "]> but was:<[" actual "]>")))


(defn find-common-prefix
  "Returns the first characters that s1 s2 share in common."
  [s1 s2]
  (apply str
         (map first
              (take-while #(= (first %) (last %))
                          (partition 2 (interleave s1 s2))))))

(defn find-common-suffix
  [s1 s2]
  (str/reverse (find-common-prefix (str/reverse s1) (str/reverse s2))))


(defn compact
  ([len expected actual msg] (format msg expected actual))
  ([len expected actual]     (compact len expected actual nil)))
