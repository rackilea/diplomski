@Controller
public class MyController {

    @RequestMapping("/endpoint") 
    public @ResponseBody WebAsyncTask<String> handleRequest (HttpServletRequest request) {

        Callable<String> callable = () -> {
            return "Callable";
        };

        ConcurrentTaskExecutor taskExecutor = new ConcurrentTaskExecutor(Executors.newFixedThreadPool(1));

        return new WebAsyncTask<>(15000L, taskExecutor, callable);

    }
}