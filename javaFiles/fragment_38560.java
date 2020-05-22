Stack<Integer> stack=new Stack<Integer>();
        stack.add(5);
        stack.add(9);
        System.out.println(stack);
        Enumeration<Integer> enumeration=stack.elements();
        while (enumeration.hasMoreElements()) {
            Integer integer = (Integer) enumeration.nextElement();
            System.out.println(integer);
        }
        Vector<Integer> vector=new Vector<Integer>();
        vector.add(5);
        vector.add(9);
        System.out.println(vector);
        Enumeration<Integer> enumeration2=vector.elements();
        while (enumeration2.hasMoreElements()) {
            Integer integer = (Integer) enumeration2.nextElement();
            System.out.println(integer);
        }