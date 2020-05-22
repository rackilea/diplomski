Observable.fromIterable(studentList) //emit items one by one
    .flatMap(studentItem -> { //make an operation on item
      if (ids.contains(studentItem.getId())) {
        studentItem.setHasPassed(true);
      }
      return Observable.just(studentItem); //emit item 
    })
    .toList() //get all items on a list
    .subscribe(finalList->{ 
         //handle the result
        }, throwable -> {
         //handlle error
    });