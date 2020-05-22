ArrayList a = new ArrayList();

    a.add("somestring");
    a.add(15);
    a.add(new ArrayList());
    a.add(new Button());

    for(int i = 0; i < a.size(); i++){
        System.out.println(a.get(i).getClass());
    }