class Lang1{
    static void init(Script s){
        //let init script passed as parameter with variables 
        s.show = { 
           def cube_root= it
        }
        s.cube_root = { Math.cbrt(it) }

        s.please = {action->
            [the: { what ->
                [of: { n ->
                    def cube_root=action(what(n))
                        println cube_root;
                }]
            }]
        }  
    }
}