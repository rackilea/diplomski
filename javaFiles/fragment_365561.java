@RequestMapping("/utilities/longProcess")
public CompletableFuture<String> async(HttpServletResponse response, HttpServletRequest request) {
    HttpSession session = request.getSession();
    return CompletableFuture.supplyAsync(() -> session.getAttribute("CACHED_RESULT"))
            .thenComposeAsync(obj -> {
                if (obj == null) {
                    CompletableFuture.supplyAsync(() -> callUrl(request, response))
                            .thenAccept(result -> session.setAttribute("CACHED_RESULT", result));
                    return CompletableFuture.completedFuture("not ready yet");
                }
                return CompletableFuture.completedFuture(obj.toString());
            });