Character[] chars = {new Character('a'),new Character('b'),new Character('c')};

String str = "";

for (Character c : chars)
    str += c.toString();

System.out.println(str);