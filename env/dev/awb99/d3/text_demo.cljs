(ns awb99.d3.text-demo
  (:require
   ["d3" :as d3]
   ))


(defn d3-text-demo [dom-sel]
  (-> d3
      (.select dom-sel)
      (.selectAll "div")
      (.data (clj->js [1 2 3]))
      (.enter)
      (.append "p")
      (.attr "text" (fn [d] d))
      (.text (fn [d] d))
      ))