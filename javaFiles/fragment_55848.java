String method1(int input) {
    if (input > 1) {
        return "Foo";
    } else if (input > 5) {
        return "Bar";
    }
    return "Baz";
}

String method2(int input) {
    if (input > 5) {
        return "Bar";
    } else if (input > 1) {
        return "Foo";
    }
    return "Baz";
}