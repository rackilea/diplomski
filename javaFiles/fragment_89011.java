package test;

import javax.jms.JMSException;
import com.ibm.mq.jms.MQConnectionFactory;

public class JmeterTest {

    public JmeterTest() {
    }

    public void test() throws JMSException {
        MQConnectionFactory factory = new MQConnectionFactory();
        factory.setAppName("myApp");
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}