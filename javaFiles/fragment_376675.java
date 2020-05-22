String str= "A809C0034F3A04C9024F80A905C5034F6008AA08C2024F4ACB024F5AFFFF";
String[] splits = str.split("A8|A9|AA");

for(String st:splits){
    System.out.println(st);
}