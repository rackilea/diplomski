public class LongRunningTaskServlet extends HttpServlet {

    private ExecutorService executor;

    @Override
    public void init() {
        executor = Executors.newSingleThreadExecutor();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // First gather necessary parameters for the background task (you shouldn't pass request/response to it!).
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");

        // Then create the background task and submit it to the executor.
        executors.submit(new LongRunningTask(param1, param2));
        // It returns a Future, you can if necessary store it in session so that you can later check if it is finished and/or has returned a result.

        // Immediately display result.
        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        executor.shutdownNow(); // Important! Pevent thread leaking.
    }

}