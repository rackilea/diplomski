protected Observable<List<CountryModel>> buildUseCaseObservable() {
    Repo mDataRepo = new Repo();
    return mDataRepo.fetchCountries()
            .flatMap(new Function<List<CountryModel>, ObservableSource<List<Long>>>() {
                @Override
                public ObservableSource<List<Long>> apply(
                        @android.support.annotation.NonNull List<CountryModel> countryModels) throws Exception {
                    return mDataRepo.storeCountries(countryModels);
                }
            }, new BiFunction<List<CountryModel>, List<Long>, List<CountryModel>>() {
                @Override
                public List<CountryModel> apply(List<CountryModel> countryModels,
                                                List<Long> longs) throws Exception {
                    return countryModels;
                }
            });
}