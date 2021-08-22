(defproject employee "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
   
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [hiccup "2.0.0-alpha1"]
                 [hiccup-table "0.2.0"]
                 [hiccup-bootstrap "0.1.2"]
                 [ring-server "0.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [ring/ring-core "1.6.1"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.4.0"]
                 [org.clojure/java.jdbc "0.4.2"]
                 [mysql/mysql-connector-java "5.1.38"]
                 [ring-json-response "0.2.0"]
                 [ring/ring-jetty-adapter "1.4.0"]]
  
  :plugins [[lein-ring "0.12.5"]]
  
  :ring {:handler employee.handler/app})
