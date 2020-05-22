class A {
    Date creation

    void initializeCreationDate() {
        creation = new Date()
    }
}

/* I'm using a different class name to make this
 * example self-contained.
 */
class B {
    String creation

    void initializeCreationDate() {
        creation = '1995-08-17'
    }
}

def obj
def condition = true

if(condition) {
    obj = new A()
} else {
    obj = new B()
}

obj.initializeCreationDate()