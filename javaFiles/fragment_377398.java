availabilityApi.getAvailability(hotelName)
        .doOnNext(availabilityResponse ->
           availabilityResponse.hotelAvailabilities().removeIf(
              availability -> availability.hotelInfo() == null
           )
        )
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());