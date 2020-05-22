/** 
 * @param m - storage model. Should not be modified after call.
 */
public ContainerImpl(Map<String, Object> m){      
  this.m = m;
}

/** A new instance with default storage model */
public static ContainerImpl createDefault() {
   // Storage reference is isolated
   return new ContainerImpl(new HashMap<>());
}