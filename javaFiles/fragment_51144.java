// assuming each observable returns response in the form of String
Observable<String> movOb = Observable.create(...);
// if you use Retrofit
Observable<String> picOb = RetrofitApiManager.getService().uploadPic(...),
Observable.zip(movOb, picOb, new Func2<String, String, MyResult>() {
      @Override
      public MyResult call(String movieUploadResponse, String picUploadResponse) {
          // analyze both responses, upload them to another server
          // and return this method with a MyResult type
          return myResult;
      }
   }
)
// continue chaining this observable with subscriber
// or use it for something else