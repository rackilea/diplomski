@SpringBootApplication
    public class SampleMicroserviceApplication {
      public static void main(String[] args) {
         SpringApplication.run(SampleMicroserviceApplication.class, args);
      }

      @Bean
      public Person john() {
         return new Person("John");
      }

      @Bean(name = "jack")
      public Person jack(){
         return new Person("Jack");
      }

      @Bean(initMethod = "init") // which person (jmsTemplate in your case to inject here??? 
      public Printer printer(Person p){
        return new Printer(p);
      }

      class Person {
        String name;

        public Person(String name) {
          this.name = name;
        }

        @Override
        public String toString() {
          return "Person{" +
                "name='" + name + '\'' +
                '}';
         }
       }

       class Printer {
         private Person p;

         public Printer(Person p) {
           this.p = p;
         }

         public void init() {
           System.out.println(p.toString());
         }
       }
    }