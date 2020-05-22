for(Field f : fields) {
   if( f.getAnnotation(OneToMany.class) != null || 
       f.getAnnotation(ManyToMany.class) != null) {
     // Here you know f has to be checked before the person is deleted ...
   }
}