import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    AppConfigMongoDB mongo = applicationContext.getBean(AppConfigMongoDB.class);
    System.out.println("db= "+mongo.getMongoDb());
    System.out.println("URL= "+mongo.getMongoDbUrl());
  }
}