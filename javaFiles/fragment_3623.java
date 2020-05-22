public static void add(JTextField Name){
    Example1 x = new Example1();
    x.setName(Name);

    JTextField a = x.getName();
    System.out.println(a.getText());
}