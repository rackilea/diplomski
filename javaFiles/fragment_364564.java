package mypackage;

public class Test {

    public static void main(String[] args) throws Exception {

        String protocolString = "TEXT";

        // code 1:
        // OLD: String protocolClassName1 = "net.spy.memcached.ConnectionFactoryBuilder.Protocol";
        String protocolClassName1 = "net.spy.memcached.ConnectionFactoryBuilder$Protocol";
        Class protocolType1 = Class.forName(protocolClassName1); 
        Object protocolEnumObject1 = Enum.valueOf(protocolType1, protocolString);

        System.out.println(protocolEnumObject1.getClass());
        // class net.spy.memcached.ConnectionFactoryBuilder$Protocol

    }

}