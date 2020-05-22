YourDbObject.getSomethingResultFromDb(params)
     //apply schedulers with subscribeOn() and observeOn() operators
     .subscribe(somethingResult -> {
         //handle result
     }, error -> {
         //handle error
     });