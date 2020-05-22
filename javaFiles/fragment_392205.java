@Configuration
public class BConfig{

 @Bean
 public A<C,D> b(){
  return new B();
 }
}

@Component 
public class E {
 @Autowired
 private A<C,D> b; 
}