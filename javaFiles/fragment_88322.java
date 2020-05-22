List<String> li = new ArrayList<>();
        li.add("abc");
        li.add("def");
        li.add("ghi");
        li.add("jkl");
        boolean inList = false;
        for (int i = 0; i < li.size(); i++) {
            if (n.equals(li.get(i))) {
                inList = true;
            }
        }
        if (inList) {
            System.out.println("client table update");
        } else {
            System.out.println("category and client table update");
        }