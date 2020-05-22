(require '[clojure.string :as string])
(string/replace
   "this is a text \\U0001B000."
   #"\\U[0-9A-F]{8}"
   replace-utf32)
;; => "this is a text \\uD82C\\uDC00."