public Class2(String name) {
    name_ = name;
}

public static void main(String[] args) {
    System.out.print("Your name: ");
    Class2 ex2 = new Class2(driver.getScanner().next());
    System.out.println("ex2" + ex2.name_);
}