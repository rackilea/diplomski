public static Result batch() {
    try {
        Result result = delete(1L);
        play.api.mvc.SimpleResult res = Await.result(result.getWrappedResult(), Duration.Inf());
        int status = res.header().status();
        //handle status
    } catch (Exception e) {
        //handle exception
    }
}