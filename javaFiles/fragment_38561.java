Set<Integer> set=new HashSet<Integer>();
        set.add(6);
        set.add(7);
        System.out.println(set);
        Enumeration<Integer> enumeration3=new Vector(set).elements();
        while (enumeration3.hasMoreElements()) {
            Integer integer = (Integer) enumeration3.nextElement();
            System.out.println(integer);
        }
        List<Integer> list=new ArrayList<Integer>();
        list.add(12);
        list.add(23);
        System.out.println(list);
        Enumeration<Integer> enumeration4=new Vector(list).elements();
        while (enumeration4.hasMoreElements()) {
            Integer integer = (Integer) enumeration4.nextElement();
            System.out.println(integer);
        }