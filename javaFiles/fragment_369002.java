@ContextConfiguration(locations = {"classpath:/activeMQ-context.xml"})
public class SpringActiveMQTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private JmsTemplate template;

    @Autowired
    private ActiveMQDestination destination;

    @Test
    public void testJMSFactory() {
        /* sending a message */
        template.convertAndSend(destination, "Hi");

        /* receiving a message */
        Object msg = template.receive(destination);
        if (msg instanceof TextMessage) {
            try {
                System.out.println(((TextMessage) msg).getText());
            } catch (JMSException e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}