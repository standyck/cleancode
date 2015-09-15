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


(defn compact
  ([len expected actual msg] (format msg expected actual))
  ([len expected actual]     (compact len expected actual nil)))
