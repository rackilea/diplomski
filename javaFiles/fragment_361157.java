String[] a = {"ax", "ay"};
String[] b = {"bx", "by"};
String[] c = {"cx", "cy"};
String[][] nodes = {a, b, c};

for (String[] n: nodes){
    for (String elem: n){
         System.out.print(elem);
    }
}