public class ComponentTreeBuilder{
   private Map<String, Component> hashMap = new HashMap<String,Component>();
   public Map<String, Component> getComponentsTree(){
      return hashMap;
   }
   public void visitComponent(Component cmp){
      // Add this component
      if(cmp != null) hashMap.put(cmp.getName(), cmp);
      Container container = (Container) cmp;
      if(container == null ) {
          // Not a container, return
          return;
      }
      // Go visit and add all children
      for(Component subComponent : container.getComponents()){
          visitComponent(subComponent);
      }
   }
}