Collections.sort(al,(s1,s2)->{

            return s1.id<s2.id?-1:s1.id>s2.id?1:s1.marks>s2.marks?-1:0;
        });
        al.forEach(p->{
            System.out.println(p);
        });