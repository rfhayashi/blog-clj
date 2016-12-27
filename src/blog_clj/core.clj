(ns blog-clj.core
  (:import (java.util UUID)))

(defn create-database []
  {})

(defn update-post [db post]
  (assoc db (:id post) post))

(defn new-id []
  (.toString (UUID/randomUUID)))

(defn create-post [db]
  (let [post {:id (new-id)}]
    {:db-after (update-post db post)
     :post post}))

(defn exists? [db post]
  (contains? db (:id post)))