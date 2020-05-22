AtomicBoolean firstReposition = new AtomicBoolean(true);
    //Create position call
    ISSPositionService service = ServiceGenerator.createService(ISSPositionService.class);

    //create observable
    Observable<ISSPositionData> issPositionCall = service.getPosition();

    Disposable disposable = issPositionCall.subscribeOn(Schedulers.io())
            .repeatWhen(completed -> completed.delay(30, java.util.concurrent.TimeUnit.SECONDS))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(positionData -> {
                LatLng currentIssPosition = new LatLng(positionData.getIssPosition().getLatitude(), positionData.getIssPosition().getLongitude());
                if (firstReposition) {
                    issMarkerOptions.position(currentIssPosition);
                    map.addMarker(issMarkerOptions);
                    firstReposition.set(false);
                }
                else {
                    issMarker.setPosition(currentIssPosition);
                }

                //animate camera so it shows current position
                map.animateCamera(CameraUpdateFactory.newLatLng(currentIssPosition));
            });