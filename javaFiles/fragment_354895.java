String rope = "and , and,and , to , to,to , you ,you , you, for ,for , for,a , a,e , e,i , i,o , o,u , u";

   // rope = rope.replaceAll(" ", "");
    rope = rope.replaceAll("and", "&");
    rope = rope.replaceAll("to", "2");
    rope = rope.replaceAll("you", "U");
    rope = rope.replaceAll("for", "4");
    rope = rope.replaceAll("a", "");
    rope = rope.replaceAll("e", "");
    rope = rope.replaceAll("i", "");
    rope = rope.replaceAll("o", "");
    rope = rope.replaceAll("u", "");
    System.out.println(rope);