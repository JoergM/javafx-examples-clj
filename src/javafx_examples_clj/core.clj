(ns javafx-examples-clj.core
  (:gen-class))


(defn -main [& args]
  (javafx.application.Application/launch clj.javafx.HelloWorld (into-array String [])))
