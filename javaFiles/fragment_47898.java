PropertyInfo pi=new PropertyInfo();
        pi.setName("name");
        pi.setValue(params[0]);// Generally array index starts from 0 not 1
        pi.setType(Integer.class);
        request.addProperty(pi);

pi= new PropertyInfo();

pi.setName("grade");
        pi.setValue(params[1]);
        pi.setType(Integer.class);
        request.addProperty(pi);