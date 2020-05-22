Pattern dot = Pattern.compile(".", Pattern.LITERAL);

Tree<String> root=
Pattern.compile("\\s+", Pattern.DOTALL).splitAsStream(input)
       .map(path->dot.splitAsStream(path).collect(new TreeCollector<>(null)))
       .collect(()->new Tree<>(null), Tree::addAll,  Tree::addAll);
String xml=root.forAll(s->'<'+s+'>', s->'<'+s+'>'+s+"</"+s+">\n", s->"</"+s+'>',
                       String::concat);
System.out.println(xml);