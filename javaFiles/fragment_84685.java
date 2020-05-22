(defn escape-utf16
  [[_ _ a b c d]]
  (format "\\u%02X%02X\\u%02X%02X" a b c d))

(defn replace-utf32
  [^String s]
  (let [n (Integer/parseInt (subs s 2) 16)]
    (-> (->> (map #(bit-shift-right n %) [24 16 8 0])
             (map #(bit-and % 0xFF))
             (byte-array))
        (String. "UTF-32")
        (.getBytes "UTF-16")
        (escape-utf16))))

(replace-utf32 "\\U0001B000")
;; => "\\uD82C\\uDC00"