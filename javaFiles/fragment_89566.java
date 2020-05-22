Pattern dot = Pattern.compile(".", Pattern.LITERAL);
Pattern.compile("\\s+", Pattern.DOTALL).splitAsStream(input)
       .map(path -> dot.split(path, 2))
       .collect(() -> new TreeMap<String,Set<String>>(),
                (m,p) -> m.computeIfAbsent(p[0], k->new TreeSet<>()).add(p[1]),
                (m1,m2) -> m2.forEach(
                           (k,v)->m1.computeIfAbsent(k,x->new TreeSet<>()).addAll(v)))
       .forEach((p,l) -> {
           System.out.print('<'+p+'>');
           for(String s:l) System.out.println('<'+s+'>'+s+"</"+s+'>');
           System.out.print("</"+p+'>');
       });