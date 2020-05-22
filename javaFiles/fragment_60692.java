public class Result {
    SR SearchResponse;

    static class SR {
        W Web;

        static class W {
            List<R> Results;

            static class R {
                public String Url;
                public String Title;

                public String toString() {
                    return Url + Title;
                }
            }
        }
    }

    public String toString() {
        return SearchResponse.Web.Results.toString();
    }
}