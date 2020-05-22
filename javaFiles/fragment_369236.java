public class DataResponse {

    private String $status;
    private Payload $payload;
   // getters and setters
}

class Payload {
    private String $nextStart;
    private List<Result> $results;

    // getters and setters
}


class Result {
    private String $key;
    private String score;
    private String to;

    // getters and setters
}