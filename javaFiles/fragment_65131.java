public class Registry{
    private static Collection<RenderedObject> register = new ArrayList<RenderedObject>();

    public static void add(RenderedObject obj){
        register.add(obj);
    }

    public static void renderAll(){
        for(RenderedObject obj : register){
            obj.render();
        }
    }
}