mCompositeDisposable.add(movieDao.getFavorites()
                .map(movieEntities -> movieEntities.stream().map(this::getMovie).collect(Collectors.toList()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    if (list.isEmpty()) {
                        mView.showEmptyState(true);
                    } else {
                        mView.onMoviesLoaded(list);
                    }
                })
        );