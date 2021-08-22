(ns employee.core

(:require [compojure.core :refer [defroutes GET POST]]
          [employee.database :as db]
          [employee.view :as view]
          [clojure.string :as string]
          [ring.util.response :as ring]))

(defn show-all-employees []
  (view/index-page))

(defn show-update-employee [id]
  (view/show-update-form (db/get-employee id)))

(defn edit-employee [id name department salary]
    (when-not (string/blank? id)
    (db/update-employee id name department salary)
     (ring/redirect "/list"))
 )

 (defn show-add-form []
  (view/show-add-form))

 (defn create-new-employee [name department salary]
  (db/insert-employee name salary department)
  (ring/redirect "/list")) 

(defn delete-employee [id]
  (when-not (string/blank? id)
    (db/delete-employee id))
  (ring/redirect "/list"))

(defn show-all-by-department [department]
  (view/all-employees-by-department department))

(defn show-login-page[]
  (view/login-page))

(defn login[username password]
  (if (empty? (db/login username password)) 
   (ring/redirect "/") (ring/redirect "/list"))
   
  )

(defroutes home-routes
    (GET "/" [] (show-login-page))
    (POST "/login" [username password] (login username password))
    (GET "/list" [](show-all-employees))
    (GET "/edit/:id" [id] (show-update-employee id))
    (POST "/edit"  [id name department salary] (edit-employee id name department salary))
    (GET "/add"  [] (show-add-form))
    (POST "/create-employee"  [name department salary] (create-new-employee name department salary))
    (GET "/delete/:id" [id]  (delete-employee id))
    (GET "/:department" [department]  (show-all-by-department department))
    )