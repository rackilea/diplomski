public void print(SuperClass superClass) {
    if (superClass instanceof SubClass) {]
        print((SubClass) superClass);
        return;
    }
    System.out.println("AppSuperClass:superclass is parameter");
}