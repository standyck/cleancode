(ns cleancode.core-test
  (:use midje.sweet)
  (:use [cleancode.core]))


#_(facts "about `first-element`"
  (fact "it normally returns the first element"
    (first-element [1 2 3] :default) => 1
    (first-element '(1 2 3) :default) => 1)

  ;; I'm a little unsure how Clojure types map onto the Lisp I'm used to.
  (fact "default value is returned for empty sequences"
    (first-element [] :default) => :default
    (first-element '() :default) => :default
    (first-element nil :default) => :default
    (first-element (filter even? [1 3 5]) :default) => :default))

(tabular
 (fact "Tests copied from Clean Code listing 15-1"
       (compact ?len ?expected ?actual ?val) => ?compact-result)

 ?len   ?expected   ?actual  ?val  ?compact-result
 0      "b"         "c"      "a"   "a expected:<[b]> but was:<[c]>"
 1      "ba"        "bc"     nil   "expected:<b[a]> but was:<b[c]>"
 1      "ab"        "cb"     nil   "expected:<[a]b> but was:<[c]b>"
 1      "ab"        "ab"     nil   "expected:<ab> but was:<ab>"
 0      "abc"       "adc"    nil   "expected:<...[b]...> but was:<...[d]...>"
 1      "abc"       "adc"    nil   "expected:<a[b]c> but was:<a[d]c>"
 1      "abcde"     "abfde"  nil   "expected:<...b[c]d> but was <b[f]d...>"
 2      "ab"        "abc"    nil   "expected:<ab[]> but was:<ab[c]>"
 0      "bc"        "abc"    nil   "expected:<[]...> but was:<[a]...>"
 2      "bc"        "abc"    nil   "expected:<[]bc> but was:<[a]bc>"
 0      "abc"       "abbc"   nil   "expected:<...[]...> but was:<...[b]...>"
 2      "abc"       "abbc"   nil   "expected:<ab[]c> but was:<ab[b]c>"
 0      "abcdde"    "abcde"  nil   "expected:<...[d]...> but was:<...[]...>"
 2      "abcdde"    "abcde"  nil   "expected:<...cd[d]e> but was:<...cd[]e>"
 0      "a"         nil      nil   "expected:<a> but was:<null>"
 2      "a"         nil      nil   "expected:<a> but was:<null>"
 0      nil         "a"      nil   "expected:<null> but was:<a>"
 2      nil         "a"      nil   "expected:<null> but was:<a>"
 10     "S&P500"    "0"      nil   "expected:<[S&P50]0> but was:<[]0>" )
