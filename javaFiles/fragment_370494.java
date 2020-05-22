public Observable<List<WhatsNew>> makeRequest { 
   return contentAPI
        .getSupportedVersionsContent()
        .flatMap(supportedVersionsMap -> {
             //... model initialization
             return contentAPI
                    .getWhatsNewFeature(model.getSupportedVersion().getAvailableVersions().get(0))
                    .compose(ReactiveUtils.applySchedulers())
                    .doOnNext(whatsNewList -> {
                    Timber.i("doOnNext invoked from supported version observable");
                    if (!whatsNewList.isEmpty())
                        model.setWhatsNews(whatsNewList);
                    })
                   .retry(1);
        });