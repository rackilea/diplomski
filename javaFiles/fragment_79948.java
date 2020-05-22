(defmulti unicode class)

(defmethod unicode java.lang.String [s]
  (read-string (str "\\u" s)))

(defmethod unicode java.lang.Long [l]
  (read-string (str "\\u" (format "%04d" l))))

(unicode "0905")
;;=>\अ
(unicode 905)
;;=>\अ