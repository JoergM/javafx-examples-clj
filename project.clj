(defproject javafx-examples-clj "0.1.0-SNAPSHOT"
  :description "This project implements the official JavaFX examples in Clojure."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [local.oracle/javafxrt "2.2.40"]]
  :aot [javafx-examples-clj.hello-world
        javafx-examples-clj.login
        javafx-examples-clj.core]
  :main javafx-examples-clj.core)
