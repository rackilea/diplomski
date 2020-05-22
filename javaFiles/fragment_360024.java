public Example2(Example1 orig){
   def d = new DefaultGrailsDomainClass(Example1.class)
   d.persistentProperties.each { val ->
       this[val.name] = orig[val.name]         
   }       
}