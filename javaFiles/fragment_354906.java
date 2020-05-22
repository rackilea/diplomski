public static void postFB(final Context context, String message) {

    final List<String> PERMISSIONS = Arrays.asList("publish_actions");

    Session session = Session.getActiveSession();

    if(session != null) {

        List<String> permissions = session.getPermissions();
        if(session.isOpened() && isSubset(PERMISSIONS, permissions)) {

            Request request = Request.newStatusUpdateRequest(session, message, new Callback() {

                @Override
                public void onCompleted(Response response) {
                    // TODO Auto-generated method stub
                    FacebookRequestError error = response.getError();
                    if(error != null)
                        //show toast of the error
                    else
                        //show toast that it is posted
                }
            });

            RequestAsyncTask task = new RequestAsyncTask(request);
            task.execute();

        }

    }

}