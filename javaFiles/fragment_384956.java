@Component
class MyService {
  @Autowired
  AuthorizeTransaction callbackTransaction;

  @Autowired
  AuthorizeTransaction immediateTransaction;

  private MeterRegistry meterRegistry;
  private Counter.Builder requestCounter;
  private Counter.Builder responseCounter;

  public MyService(MeterRegistry meterRegistry) {
    this.meterRegistry = meterRegistry;
    initCounters();
  }

  private initCounters() {
    requestCounter = Counter.builder("iso_request");
    responseCounter = Counter.builder("iso_response");
  }

  public ISOMsg process(ISOMsg request) {
    ISOMsg response = null;

    try {
      switch(request.getMTI()) {  // org.jboss.iso.ISOMsg
        case "0100":
        case "0200":
          requestCounter.tag("mti", request.getMTI()).registry(meterRegistry);
          response = immediateTransaction.process(request);
          responseCounter.tags("mti", request.getMTI(), "response_code", "0101").registry(meterRegistry);
          // here I want to increment the response counter but with different MTIs and response codes
          break;
        case "0120":
        case "0121"
          response = callbackTransaction.process(request);
          break;
        default:
          log.error("error here")
      }
    } catch (Exception e) {
      log.error("error here")
    }

    return response;
  }
}