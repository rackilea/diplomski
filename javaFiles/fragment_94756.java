public interface Factory {
    Properties getProperties();
}

public class DBFactory implements Factory {
    Properties getProperties() {
        //DB implementation
    }
}

public class FileFactory implements Factory {
    Properties getProperties() {
        //File implementation
    }
}

public SomeClassUsingFactory {
    private Factory propertyFactory;

    public void setPropertyFactory(Factory propertyFactory) {
        this.propertyFactory = propertyFactory;
    }

    public void someMainMethod() {
        propertyFactory.getProperties();
    }
}

//Spring context config
<!-- create a bean of DBFactory (in spring 'memory') -->
  <bean id="dbPropertyFactory"
    class="my.package.DBFactory">
    <constructor-arg>
      <list>
        <value>Some constructor argument if needed</value>
      </list>
    </constructor-arg>
  </bean>
 <!-- create a bean of FileFactory (in spring 'memory') -->
  <bean id="filePropertyFactory"
    class="my.package.FileFactory">
    <constructor-arg>
      <list>
        <value>Some constructor argument if needed</value>
      </list>
    </constructor-arg>
  </bean>
<!-- create a bean of SomeClassUsingFactory -->
  <bean id="MainClass"
    class="my.package.SomeClassUsingFactory">
    <!-- specify which bean to give to this class -->
    <property name="propertyFactory" ref="dbPropertyFactory" />
  </bean>