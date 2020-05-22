(ns my-project.classes)

(gen-class
  :name my_project.my_parent_class.MyParentClass
  :init init
  :state state)

(defn -init []
      [[]
       (ref {:library-object-one "foo"
             :library-object-two "bar"})])

(gen-class
  :name my_project.my_child_class.ChildClass
  :extends my_project.my_parent_class.MyParentClass)