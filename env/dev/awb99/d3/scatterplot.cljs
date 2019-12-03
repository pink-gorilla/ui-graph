(ns awb99.d3.scatterplot
  (:require 
    ["d3" :as d3]

  ))

;; does not work yet

(let [Width       300 ;;Width in pixels
      n           100 ;;Number of data
      scale       (d3.scale/linear :domain [0 1] :range [0 Width])

      sample-data (for [_ (range n)]
                    {:x (rand)
                     :y (rand)
                     :class (if (> (rand) 0.5)
                              "A" "B")})

      scatterplot (-> d3 (.select "#example")
                      (.append "svg:svg")
                      (.style {:border "2px solid darkGray"
                              :border-radius 8})
                      (.attr {:width  Width
                             :height Width}))

      points      (-> scatterplot
                      (.selectAll "circle.num")
                      (.data sample-data)
                      (.enter) (.append "svg:circle")
                      (.attr {:class "num"
                             :r 5
                             :fill #(condp = (:class %)
                                      "A" "darkRed"
                                      "B" "darkBlue")
                             :cx #(.scale (:x %))
                             :cy #(.scale (:y %))}))]


