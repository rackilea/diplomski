;; renamed mypkg.Ugly to foo.TestInterop2 when doing my tests
user> (let [t (foo.TestInterop2.)]
        (.foo t (boolean true)))
"bool: true"

;;; type-hinting the Var
user> (def #^foo.TestInterop2 x (foo.TestInterop2.))
#'user/x
user> (.foo x (boolean true))
"bool: true"