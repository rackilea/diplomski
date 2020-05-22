@CamelSpringBootTest
@SpringBootTest(classes = [SnmpTrapReceiverApplication::class])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisableJmx(false)
@ExtendWith(MockitoExtension::class)
@EnableAutoConfiguration
class SnmpTrapRouteTest {

    @MockBean
    lateinit var repo: PojoRepo

    @Produce
    lateinit var producerTemplate: ProducerTemplate

    @Autowired
    lateinit var camelContext: CamelContext

    @Test
    @Throws(Exception::class)
    fun testSnmpRoute() {

        AdviceWithRouteBuilder.adviceWith(camelContext, "snmp-trap-route") { routeBuilder ->
            routeBuilder.replaceFromWith("direct:snmp-from")
        }

        // Create a PDU object to send to the SNMP endpoint, rather than SNMP XML
        val trap = PDU()
        trap.type = PDU.TRAP
        trap.requestID = Integer32(123456789)
        trap.add(VariableBinding(OID("1.2.3.4.5"), OctetString("snmp-trap-payload")))

        // Create a new DefaultExchange and add an SnmpMessage object as the in-message,
        // constructed with the camelContext and the PDU object
        val exchange = DefaultExchange(camelContext)
        exchange.setIn(SnmpMessage(camelContext, trap))
        producerTemplate.setDefaultEndpointUri("direct:snmp-from")
        producerTemplate.send(exchange)

        verify(repo, atLeast(1)).save(any())
    }
}