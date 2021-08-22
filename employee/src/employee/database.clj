(ns employee.database
  (:require [clojure.java.jdbc :as sql])
  (:import (java.security MessageDigest)))

(def connection
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost:8889/sys?autoReconnect=true&useSSL=false"
   :user "root"
   :password ""}) ;;add your password for local db

    
 (defn set-sector [sector]
   (if (= sector "Marketing") 1
   (if (= sector "Accounting") 2
   (if (= sector "IT") 3
   (if (= sector "Human Resources") 4
   (if (= sector "Other") 5))))))