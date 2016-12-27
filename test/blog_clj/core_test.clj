(ns blog-clj.core-test
  (:require [clojure.test :refer :all]
            [blog-clj.core :refer :all]))

(deftest new-post-is-added-to-db
  (let [db (create-database)
        post {:id 1}]
    (is (not (exists? db post)))
    (is (exists? (update-post db post) post))))

