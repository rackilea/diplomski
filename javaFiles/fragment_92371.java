public class SomeWebController {
    private MyBusinessLogicService  myBusinessLogicService;

    public SomeWebController(MyBusinessLogicService myBusinessLogicService) {
        this.myBusinessLogicService = myBusinessLogicService;
    }
    ...
}