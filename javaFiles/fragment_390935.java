searchGames().subscribe(new new Subscriber<List<GameModel>>() {
    @Override
    public void onNext(List<GameModel> gameModels) {
         //TODO make sth useful with models
    }

    @Override
    public void onCompleted() { }

    @Override
    public void onError(Throwable e) { }
)