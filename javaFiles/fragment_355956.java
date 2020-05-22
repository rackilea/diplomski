@TypeName("Parent")
    class Parent {
        @Id
        private String parentId
        private Set<Child> children
    }

    @TypeName("Child")
    class Child {
        private String childId
        private String someProp
    }