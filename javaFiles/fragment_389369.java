public class Outer {     
    protected Inner inner = null; 
    public Inner getInner() {
        return inner;
    }      
    protected void something(){ }
    public void function(){
       inner.fixParent(this); // solve the reference lost
       inner.innerFunction(this);
    }
    public static void main(String[] args){
        String str = "{\"inner\":{\"name\"=\"test\"}}";
        Outer outer = (new Gson()).fromJson(str,Outer.class);
        System.out.println(outer.getInner().name);
        outer.function();
    }

    public class Inner {
        public String name = null;

        private void fixParent(Outer parent){// solution here
            try {
                field = Inner.class.getDeclaredField("this$0");
                field.setAccessible(true);
                field.set(this, parent);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
       }
        protected void innerFunction(){
            Field field = null;                       
            something();//now works 
        }
    }
}