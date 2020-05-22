public class ExchangeHandler extends AbstractHandler {
    @Inject
    ExchangeHandler(@Exchange NetworkService service) {
         super(service);
    }
}