(ns awb99.d3.circle-demo
  (:require
   ["d3" :as d3]))


(def circle-data
  #js [{:cx 20 :cy 20 :radius 20 :r 20 :color "green" :style {:fill "purple"}}
       {:cx 70 :cy 70 :radius 20 :r 20 :color "purple"}])

;svgContainer.append ("circle") .attr ("cx",20) .attr ("cy",20) .attr ("r",20) .style ("fill","purple");


(defn d3-circle-demo [dom-sel]
  (let [svgContainer (.select d3 dom-sel)
        svg (-> svgContainer
                (.append "svg")
                (.attr "width" 150)
                (.attr "height" 150))]

   ;Add circles to the svgContainer
    (-> svg
        (.append "circle")
        (.attr "cx" 20)
        (.attr "cy" 20)
        (.attr "r" 20)
        (.style "fill" "purple"))


    (-> svg
        (.selectAll "circle")
        (.data circle-data)
        (.enter)
        (.append "circle"))))

