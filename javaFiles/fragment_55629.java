//Set tags for your requests when you build them:
            Request request = new Request.Builder().
            url(url).tag("requestKey").build();

            //When you want to cancel:
            //A) go through the queued calls and cancel if the tag matches:
            for (Call call : mHttpClient.dispatcher().queuedCalls()) {
                if (call.request().tag().equals("requestKey"))
                    call.cancel();
            }

            //B) go through the running calls and cancel if the tag matches:
            for (Call call : mHttpClient.dispatcher().runningCalls()) {
                if (call.request().tag().equals("requestKey"))
                    call.cancel();
            }