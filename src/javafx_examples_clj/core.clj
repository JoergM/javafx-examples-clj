(ns javafx-examples-clj.core
  (:gen-class))

(defmacro launch [class]
  `(javafx.application.Application/launch  ~class (into-array String [])))

(defn -main [& args]
  (println "What Demo shall I start?")
  (println "1 - Hello World")
  (println "2 - Login Form")
  (case (read-line)
    "1" (launch clj.javafx.HelloWorld)
    "2" (launch clj.javafx.Login)
    (println "Don't know what you mean. Start again.")))
