import play.api.mvc.EssentialAction;
    import play.api.mvc.EssentialFilter;
    import play.api.mvc.RequestHeader;
    import play.api.mvc.ResponseHeader;
    import play.filters.gzip.Gzip;
    import play.filters.gzip.GzipFilter;
    import scala.Function2;
    import scala.runtime.AbstractFunction2;

    public class MyGzipFilter implements EssentialFilter {

        private Function2<RequestHeader,ResponseHeader,Object> shouldGzip = new AbstractFunction2<RequestHeader,ResponseHeader,Object>(){

            @Override
            public Boolean apply(RequestHeader v1, ResponseHeader v2) {
                return shouldGzipFunction(v1,v2);
            }

        };
        private GzipFilter filter = new GzipFilter(Gzip.gzip(8192),102400,shouldGzip);

        @Override
        public EssentialAction apply(EssentialAction next) {
            return filter.apply(next);
        }

        private boolean shouldGzipFunction(RequestHeader v1, ResponseHeader v2) {
//your logic here

       }
    }