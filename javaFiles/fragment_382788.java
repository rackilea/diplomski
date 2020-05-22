@Configuration
public class ConfigProps{

@Bean
public Validator validator(){
 return new LocalValidatorFactoryBean();
}

@Bean 
public MethodValidationPostProcesssor methodValidationPostProcessor(){
  MethodVaidationPostProccessor methodPostProcessor = new MethodValidationProcessor();
  methodPostProcessor.setValidator(validator());
  return methodPostProcessor;
}