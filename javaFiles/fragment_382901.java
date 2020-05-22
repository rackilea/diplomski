@Configuration
public class CORE_Provider implements Provider<ProvidedInterface> {
      @Override @Bean
      public ProvidedInterface get() {
          return new CORE_Provided();
      }
}