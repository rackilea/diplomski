Pattern dot = Pattern.compile(".", Pattern.LITERAL);
Pattern.compile("\\s+", Pattern.DOTALL).splitAsStream(input)
       .map(path -> dot.split(path, 2))
       .collect(groupingBy(path->path[0],
                    mapping(path->path[1], toCollection(TreeSet::new))))
       .forEach((p,l) -> {
           System.out.print('<'+p+'>');
           for(String s:l) System.out.println('<'+s+'>'+s+"</"+s+'>');
           System.out.print("</"+p+'>');
       });