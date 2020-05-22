void method(Object o) { }

void method(String s) { }

method("hello");          // calls method(String)
method((Object) "hello"); // calls method(Object)