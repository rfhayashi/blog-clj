(ns blog-clj.core)

(defn create-database []
  {})

(defn update-post [db post]
  (assoc db (:id post) post))

(defn exists? [db post]
  (contains? db (:id post)))