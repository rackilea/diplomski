import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AnnotationConfigTest {


    @Autowired PrototypeBeanFactory prototypeFactory;

    @Test
    public void test() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool( 10 );

        for ( int i = 0; i < 10; i++ ) {
            service.execute( new Runnable() {
                @Override
                public void run() {
                    Value value = prototypeFactory.getBean("value", Value.class);
                    System.out.println( "value1.x = "  + value.getX() );
                }
            } );
        }

        service.shutdown();
        service.awaitTermination( 1, TimeUnit.MINUTES );
    }

    public static class Value {
        @Autowired
        private Integer x;

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }
    }



    @Configuration
    public static class Config {

        @Bean
        public Integer x() {
            return 1;
        }

        @Bean
        @Scope(value="prototype")
        public Value value() {
            return new Value();
        }

        @Bean
        public PrototypeBeanFactory prototypeFactory(){
            return new PrototypeBeanFactory();
        }

    }


    public static class PrototypeBeanFactory implements ApplicationContextAware{
        private ApplicationContext applicationContext;
        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
        }

        public<T> T getBean(String name, Class<T> clazz){
            return this.applicationContext.getBean(name, clazz);
        }

    }
}