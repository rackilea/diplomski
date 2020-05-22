final MyAsyncTask async = new MyAsyncTask();
async.finished(new Callable() {
    // the function called during async.onPostExecute;
    doSomething(async.getResult());
});
async.execute(url);