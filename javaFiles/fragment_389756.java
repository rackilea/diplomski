// class variable
// boolean isRunning = false;

protected void onNextPageRequested(int page) {


    if (!isRunning) {

        isRunning = true;

        backgroundTask = new AsyncTask<Integer, Void, List<Bola>>() {

            protected List<Bola> doInBackground(
                    Integer... params) {
                int page = params[0];
                return Adapter.getRows(page);
            }

            protected void onPostExecute(
                    List<Bola> result) {
                if (isCancelled()){
                    backgroundTask.cancel(true);                        
                }

                list.addAll(result);
                nextPage();
                notifyDataSetChanged();

                if (result.size() > 0) {
                    // still have more pages
                    notifyMayHaveMorePages();
                } else {
                    notifyNoMorePages();
                }


            };
        }.execute(page);
            isRunning = false;
       }

    }