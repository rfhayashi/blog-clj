(ns blog-clj.core-test
  (:require [clojure.test :refer :all]
            [blog-clj.core :refer :all]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

(defspec new-post-is-added-to-db
         100
         (let [db (create-database)]
           (prop/for-all []
             (let [{:keys [post db-after]} (create-post db)]
               (is (not (exists? db post)))
               (is (exists? db-after post))))))

(defspec post-ids-are-unique
         100
         (let [ids* (atom #{})
               db (create-database)]
           (prop/for-all []
                         (let [{:keys [post]} (create-post db)]
                           (is (not (@ids* (:id post))))
                           (swap! ids* conj (:id post))))))
