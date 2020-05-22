//save Child with Parent at same 
    @PostMapping(value = "/onetomany")
    public String OneToMany(@RequestBody Parent parent)
    {
        System.out.println("Parent: "+parent.toString());
        for (Child child : parent.getChild()) {
            child.setParent(parent);
        }

        parent.setChild(parent.getChild());
        parentRepository.save(parent);
        return "saved";

         /*{
            "name":"Romil",
            "child":[
               {"account":"1"},
               {"account":"2"}
             ]
         }*/
    }

        //save Child with Parent's ID
        @PostMapping(value = "/onetomanyPID")
        public String OneToMany(@RequestBody Child child)
        {
            child.setParent(child.getParent());
            childRepository.save(child);
            return "saved";

            /*{
            "account":"3",
             "parent":{
                 "parentId":"1",
                  "name":"Romil"
              }
            }*/
        }