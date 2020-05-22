final ArticleRepo repository = getCurrentArticleRepo();

final Observable<List<ArticleEntity>> refresh = repository.refreshArticles().flatMap(new Func1<ArticleRepo, Observable<List<ArticleEntity>>>() {
    @Override
    public Observable<List<ArticleEntity>> call(final ArticleRepo updated) {
        return updated.getAllArticles();
    }
}).flatMap(new Func1<List<ArticleEntity>, Observable<List<ArticleEntity>>>() {
    @Override
    public Observable<List<ArticleEntity>> call(final List<ArticleEntity> articles) {
        return repository.save(articles);
    }
});

repository.getAllArticles().onErrorResumeNext(refresh).filter(new Func1<List<ArticleEntity>, Boolean>() {
    @Override
    public Boolean call(final List<ArticleEntity> articles) {
        return articles == null || articles.size() == 0;
    }
}).switchIfEmpty(refresh).subscribe(new Action1<List<ArticleEntity>>() {
    @Override
    public void call(final List<ArticleEntity> articles) {
        // do something here
    }
});