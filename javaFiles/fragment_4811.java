public <T> Entity collide(Entity a, Class<T> desiredClass)
 {

     for (Entity b : entities)
         if (desiredClass.isAssignableFrom( b.getClass() ) && collide(a, b))
             return b;
     return null;
 }