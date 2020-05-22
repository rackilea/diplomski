private static class MyTaskParams {
    int amount;
    String name;

    MyTaskParams(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }
}

public void updateAtcHits (int amount, String name) {

    MyTaskParams params = new MyTaskParams(amount,name);
    new updateHitAsyncTask(mAtcDao).execute(params);
}

private class updateHitAsyncTask extends AsyncTask<MyTaskParams,Void,Void>{

    private AtcDao mAsyncTaskDao;

    public updateHitAsyncTask(AtcDao mAtcDao) {

        mAsyncTaskDao = mAtcDao;
    }

    @Override
    protected Void doInBackground(MyTaskParams... myTaskParams) {
        int amount =myTaskParams[0].amount;
        String name = myTaskParams[0].name;
        mAsyncTaskDao.UpdateHitAmount(amount, name);
        return null;
    }
}