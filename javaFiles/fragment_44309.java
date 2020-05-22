Observable
                .fromCallable(new Callable<List<Post>>() {
                    @Override
                    public List<Post> call() throws Exception {
                        // TODO: get posts
                        return posts;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(posts -> {
                    // TODO: update UI
                }, throwable -> {
                    // TODO
                })