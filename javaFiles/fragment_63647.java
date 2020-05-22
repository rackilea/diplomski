public static void main(String[] args) {
    MyStructure ms = new MyStructure("FOO BAR YY\n" + 
            "- foo bar y\n" + 
            "- foo bar x\n" + 
            "FOO BAR AA\n" + 
            "- foo bar z\n" + 
            "- foo bar y");
    System.out.println("Before: " + ms);
    String toAdd = "FOO BAR YY;- foo bar new entry";
    String[] fields = toAdd.split(";", 2);
    ms.add(fields[0], fields[1]);
    System.out.println("After: " + ms);
}