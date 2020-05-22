@Service
    public class TestService {
        @Autowired
        private WebServiceTemplate webServiceTemplate;

        public Double getValue(String paramOne) {

             request.setParam(paramOne);

            Response response = (Response) webServiceTemplate.marshalSendAndReceive(
                    request);

            return response.Result();
        }
    }