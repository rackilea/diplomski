// Necessary; you can't just use ext.SomeThing in the task later because 
// it is available at compile-time, but apparently not at runtime. Although
// it does work if you use project.ext.SomeThing. However, I just found this
// to be more convenient.
def SomeThing = ext.SomeThing
def SomeOtherThing = ext.SomeOtherThing

task someTask(type: DefaultTask) {
    // You have to use def; you cannot use the actual type because
    // it is not available at compile-time. Also, since you only
    // have a class object, you cannot use "new" directly; you have to
    // create a new instance by calling newInstance() on the class object
    def someThing = SomeThing.newInstance(...)

    // If you are calling static methods you can invoke them directly
    // on the class object. Again, you have to use def if the return
    // type is something defined within my-library.
    def foo = SomeOtherThing.staticMethod(...)
}