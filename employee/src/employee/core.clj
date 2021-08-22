(ns employee.core

(:require [compojure.core :refer [defroutes GET POST]]
          [employee.database :as db]
          [employee.view :as view]
          [clojure.string :as string]
          [ring.util.response :as ring]))