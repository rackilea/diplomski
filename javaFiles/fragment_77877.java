(defclass foo ()
  (foo-x))

(finalize-inheritance (find-class 'foo)) ;this is needed to be able to query class slots and other properties. Or, class is automatically finalized when its first instance is created

(class-slots (find-class 'foo))
=> (#<STANDARD-EFFECTIVE-SLOT-DEFINITION FOO-X>)

(slot-definition-name (first (class-slots (find-class 'foo))))
=> FOO-X