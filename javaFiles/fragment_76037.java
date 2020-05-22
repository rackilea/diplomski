static Map<String, List> maps = new HashMap<>();
static {
    maps.put(Updatable.class.getName(), new ArrayList<Updatable>());
    maps.put(Removable.class.getName(), new ArrayList<Removable>());
    maps.put(Renderable.class.getName(), new ArrayList<Renderable>());
    maps.put(Collidable.class.getName(), new ArrayList<Collidable>());
}
public static void add(Object obj){
    maps.get(obj.getClass().getName()).add(obj);
}