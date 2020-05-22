class YourSubClass extends YourClass {
    YourSubClass() {
        super(() -> {
            System.out.println("This is the unexposed code");
        });
    }

    ...
}