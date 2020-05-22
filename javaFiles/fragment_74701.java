;; Depends on cheshire and data.xml
(ns user
  (:require [cheshire.core :as json]
            [clojure.data.xml :as xml]))

(defrecord Person [name age hometown])
(defrecord Animal [name sound])

(def xml-attrs {Person [:name :age]
                Animal [:name]})

(defn record->xml-data [rec]
  (let [tag (-> rec class .getSimpleName .toLowerCase keyword)
        attrs (select-keys rec (xml-attrs (class rec)))
        content (for [[k v] rec
                      :when (not (contains? attrs k))]
                  (xml/element k nil (str v)))]
    (apply xml/element tag attrs content)))

(defn record->xml [rec]
  (xml/emit-str (record->xml-data rec)))

(defn record->json [rec]
  (json/generate-string rec))