(App) getApplication()).getWebApi()
              .createCourse(onlinecourse))
              .subscribeOn(Schedulers.io())          
              .observeOn(AndroidSchedulers.mainThread()) 
              .subscribe(new Observer<Course>() {
                @Override
                public void onCompleted() {
                    //Code here
                }

            @Override
            public void onError(Throwable e) {
                    //Code here
            }

            @Override
            public void onNext(Course course) {
                    //Code here - Do something with course!

            }