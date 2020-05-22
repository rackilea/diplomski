Object o = request.getParameter("languages");
 if(o instanceof List<?>){
    List<NamedFacebookType > list = (List<NamedFacebookType>) o;
    String []names = new String[list.size()];
    int i=0;
    for(NamedFacebookType namedFacebookType : list){
        names[i]=namedFacebookType.getName();
        i++;
    }

    for(String name:names){
        System.out.println(name);
    }
}