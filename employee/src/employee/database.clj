(ns employee.database
  (:require [clojure.java.jdbc :as sql])
  (:import (java.security MessageDigest)))

(def connection
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost:8889/sys?autoReconnect=true&useSSL=false"
   :user "root"
   :password ""}) ;;add your password for local db

    
 (defn set-department [department]
   (if (= department "Marketing") 1
   (if (= department "Accounting") 2
   (if (= department "IT") 3
   (if (= department "Human Resources") 4
   (if (= department "Other") 5))))))


(defn get-all-employees []
  (into [] (sql/query connection ["select * from employees"])))

(defn update-employee[id name department salary]
  (sql/update! connection :employees {:id id :name name :category (set-department department) :salary salary} ["id = ?" id]))

(defn get-employee [id]
  (into [] (sql/query connection ["select * from employees where id = ?" id])))

(defn find-by-department [department]
  (into [] (sql/query connection ["select * from employees where department = ?" department])))

(defn insert-employee [name salary department]
  (sql/insert! connection :employees [:name :salary :department] [name salary (set-department department)]))

 (defn delete-employee [id]
 (sql/delete! connection :employees
            ["id = ?" id]))
 
 
 (defn md5 [^String s]
  (let [algorithm (MessageDigest/getInstance "MD5")
        raw (.digest algorithm (.getBytes s))]
    (format "%032x" (BigInteger. 1 raw))))

;; admin

 (defn login [username password]
   (into [] (sql/query connection ["select * from user where username = ? and password=?" username (md5 password)])))
