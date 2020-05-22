public class MyBean
{
   private MyOtherBean myOtherBean;

   public MyBean(MyOtherBean myOtherBean)
   {
      this.myOtherBean = myOtherBean;
   }
}

//your spring config xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

<!-- Definition of your bean -->
<bean id="myBean" class="com.yourpackage.MyBean">
  <constructor-arg ref="myOtherBean"/>
</bean>

<bean id="myOtherBean" class="com.yourpackage.MyOtherBean"/>

</beans>