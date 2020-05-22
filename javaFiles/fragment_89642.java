@Autowired
private MyController myController;

@RequestMapping("/send3")
public void callAsyn3() throws InterruptedException, ExecutionException {
     Future<Boolean> go = myController.sendMail3("test");
}

@Async
public Future<Boolean> sendMail3(String msg) throws InterruptedException {
    boolean acceptedYet = false;
    Thread.sleep(1000 * 12);
    if (!msg.equalsIgnoreCase("")) {
        acceptedYet = true;
    }
    return new AsyncResult<>(acceptedYet);
}