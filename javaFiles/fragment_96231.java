Observable.just(user.getUserId())
        .subscribeOn(Schedulers.io())
        .map(this::getImageList)
        .flatMap(images -> {
               // you can access images size here, update footer
               footer.setText(images.size() + " images");
               // pass full list of images to your view, i.e like this
               view.setImages(images);
               return Observable.fromIterable(images)
            })
            .take(4)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(image -> { 
                                // add image to grid 
                                },
                       error -> { 
                                // handle error
                                }
                       () ->    {
                                // four images were emitted, emission complete
                                adapter.notifyDatasetChanged();
                                });