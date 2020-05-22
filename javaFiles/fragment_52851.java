new BB()
        AA()                       // super(); -> AA constructor
                A#foo()            // private method call 
                        B#goo()    // polymorphic method call
        BB()                       // BB constructor
                B#foo()            // plain method call