new SuperCoolAsyncTask<ArrayList<MyItem>>() {
    @Override
    protected void onAsyncTaskResult(ArrayList<MyItem> o) {
            AppConstants.scoreStatistics = o;
    }
}.execute(get_url_score_statistics());