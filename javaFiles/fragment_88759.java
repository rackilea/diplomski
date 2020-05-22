ArrayList<String> list = new ArrayList<String>();
list.add("a");
Method[] methods = List.class.getMethods();
for(Method m : methods) {
    if(m.getName().equals("add")) {
        m.invoke(list, 1);
        break;
    }
}
System.out.println(list.get(0));
System.out.println((Object) list.get(1));