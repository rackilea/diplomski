@RequestScope
@Controller
public class SomeController {

@Autowired
private SomeServiceImpl iSomeService;

@ResponseBody
@GetMapping("/some-func")
public String someFunc(HttpServletRequest request) throws ExecutionException, InterruptedException {
    HttpSession session = request.getSession();
    CompletableFuture<HttpSession> completableFuture= iSomeService.myAsyncFunction(session, "hello");
    HttpSession session1=completableFuture.get();
    System.out.println(session1.getAttribute("key"));
    return "ok";
}
}

@RequestScope
@Service
public class SomeServiceImpl {

@Async("threadPoolTaskExecutor")
public CompletableFuture<HttpSession> myAsyncFunction(HttpSession session, String s) {
    session.setAttribute("key", s);
    return CompletableFuture.completedFuture(session);
}
}