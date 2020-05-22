String s = (String) ois.readObject();
Object o = ois.readObject();
if("add".equals(s)){
    list.add(o);
} else if ("remove".equals(s)){
    list.remove(o);
}