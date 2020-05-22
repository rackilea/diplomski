import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class OrderingOfInstantiation {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(OrderingOfInstantiation.class);
    }

    @Component
    @CollectionOrder(collection = "myBeans", order = 1)
    public static class MyBean1 {{
        System.out.println(getClass().getSimpleName());
    }}

    @Component
    @CollectionOrder(collection = "myBeans", order = 2)
    public static class MyBean2 {{
        System.out.println(getClass().getSimpleName());
    }}

    @Configuration
    public static class CollectionsConfig {

        @Bean
        List<Object> myBeans() {
            return new ArrayList<>();
        }
    }

    // PopulateConfig will populate all collections beans
    @Configuration
    public static class PopulateConfig implements ApplicationContextAware {

        @SuppressWarnings("unchecked")
        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            Multimap<String, Object> beansMap = MultimapBuilder.hashKeys().arrayListValues().build();

            // get all beans
            applicationContext.getBeansWithAnnotation(CollectionOrder.class)
                    .values().stream()

                    // get CollectionOrder annotation
                    .map(bean -> Pair.of(bean, bean.getClass().getAnnotation(CollectionOrder.class)))

                    // sort by order
                    .sorted((p1, p2) -> p1.getRight().order() - p2.getRight().order())

                    // add to multimap
                    .forEach(pair -> beansMap.put(pair.getRight().collection(), pair.getLeft()));

            // and add beans to collections
            beansMap.asMap().entrySet().forEach(entry -> {
                Collection collection = applicationContext.getBean(entry.getKey(), Collection.class);
                collection.addAll(entry.getValue());

                // debug
                System.out.println(entry.getKey() + ":");
                collection.stream()
                        .map(bean -> bean.getClass().getSimpleName())
                        .forEach(System.out::println);
            });
        }

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    @Documented
    public @interface CollectionOrder {
        int order() default 0;

        String collection();
    }
}