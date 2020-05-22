public class HttpManager implements HttpResponseListener 
    {   
        public HttpState state;
        private String result;
        private byte[] byteResult;

        HttpRequest request;

        public HttpManager()
        {
            request = new HttpRequest();
            request.setMethod(Net.HttpMethods.GET); //or POST
            request.setContent(""); //you can put here some PUT/GET content
            request.setUrl(url);
            Gdx.net.sendHttpRequest(request, this);
        }

        @Override
        public void handleHttpResponse(HttpResponse httpResponse) 
        {
            if( httpResponse.getStatus().getStatusCode() != 200 )
            {
                //ERROR
                float errorCode = httpResponse.getStatus().getStatusCode();
            }
            else
            {
                byte[] byteResult = httpResponse.getResult(); //you can also get result as String by using httpResponse.getResultAsString();
            }   
        }

        @Override
        public void failed(Throwable t) 
        {
            // TODO Auto-generated method stub  
        }

        @Override
        public void cancelled() 
        {
            // TODO Auto-generated method stub  
        }
    }