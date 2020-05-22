public class  EhachePropertiesReplacer implements BeanFactoryPostProcessor , EnvironmentAware{

       private Environment environment;

       private List<String> ehcachePropertyNames;

       public void setEhcahePropertyNames(List<String> ehcachePropertyNames){
          this.ehcachePropertyNames = ehcachePropertyNames;
       }

       public void setEnvironment(Environment environment){
          this.environment = environment;
       }

       public void postProcessBeanFactory(ConfigurableBeanFactory bf){
          for(String ehcahePropertyName : ehcahePropetyNames){
             String ehcachePropertyValue = evironment.getProperty(ehcahePropertyName);
             System.setProperty(ehcahePropertyName ,ehcachePropertyValue);
          }      
       }
   }

}