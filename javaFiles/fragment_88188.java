String[][] arr = {{"1", "one"}, 
                           {"5", "five"}};

String str = "String5";
for(String[] a: arr) {
    str = str.replace(a[0], a[1]);
}

System.out.println(str);