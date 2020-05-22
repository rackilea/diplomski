[ "a", "b", "c", "d" ]
   ^
(remove element at index 0)

[ "b", "c", "d" ]
        ^
(remove element at index 1... uh oh, we missed "b"!)

[ "b", "d" ]
              ^
(remove element at index 2... ERROR; index out of bounds)