String getJNDITree() {
    Context context=null;
    try {
        context = new InitialContext();
    } catch (NamingException e1) {e1.printStackTrace();}

    List<String>roots=Arrays.asList("java:comp","java:module","java:app","java:global");

    StringBuilder tree=new StringBuilder();
    for(String root:roots)
        recursiveDeepVisit(context,root,"",tree);   

    return tree.toString()+"\n";
}

void recursiveDeepVisit(Context context,String path,String prefix,StringBuilder tree){
    tree.append("\n"+prefix+path);
    try {
        NamingEnumeration<NameClassPair> list = context.list(path);
        while (list.hasMore()) {
            String innerPath = path+"/"+list.next().getName();
            recursiveDeepVisit(context, innerPath, "    "+prefix,tree);
        }
    } catch (Exception e) {}
}