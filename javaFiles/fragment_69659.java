class A {
    Date creation
}

/* I'm using a different class name to make this
 * example self-contained.
 */
class B {
    String creation
}

class DateInitializer {
    static void initializeCreationDate(A object) {
        object.creation = new Date()
    }

    static void initializeCreationDate(B object) {
        object.creation = '1995-08-17'
    }
}

def obj
def condition = true

if(condition) {
    obj = new A()
} else {
    obj = new B()
}

obj.metaClass.mixin DateInitializer
obj.initializeCreationDate()