(.foo (mypkg.Ugly.) 5)
;=> "obj: 5"

(.foo (mypkg.Ugly.) true)
;=> "obj: true"

(.foo (mypkg.Ugly.) (boolean true))
;=> "bool: true"


(def u (mypkg.Ugly.))
(.foo u (boolean true))
;=> "obj: true"

(.foo #^mypkg.Ugly u (boolean true))
;=> "bool: true"