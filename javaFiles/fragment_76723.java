hackerNewsApi.getPosts()
 .subscribeOn(Schedulers.io())
 .flatMapIterable(posts -> posts)
 .flatMap(post -> hackerNewsApi.getStory(post))
 .toList()
 .observeOn(AndroidSchedulers.mainThread())
 .subscribe(allStories -> { /* ... */ }, error -> { /* ... */ });