(defproject awb99.graph.demo "0.0.1"
  :license {:name "MIT"}
  ;:deploy-repositories [["releases" :clojars]]
  :repositories [["clojars" {:url "https://clojars.org/repo"
                             :username "awb99"
                             :sign-releases false}]]
  :dependencies 
  [[org.clojure/clojurescript "1.9.854"]
   [thheller/shadow-cljs "2.0.40"]]
  :source-paths ["src"])