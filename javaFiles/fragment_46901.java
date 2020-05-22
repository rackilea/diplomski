JpaRepositoriesAutoConfiguration:
      Did not match:
         - @ConditionalOnBean (types: javax.sql.DataSource; SearchStrategy: all) did not find any beans of type javax.sql.DataSource (OnBeanCondition)
      Matched:
         - @ConditionalOnClass found required class 'org.springframework.data.jpa.repository.JpaRepository' (OnClassCondition)
         - @ConditionalOnProperty (spring.data.jpa.repositories.enabled=true) matched (OnPropertyCondition)