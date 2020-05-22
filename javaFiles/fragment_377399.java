availabilityApi.getAvailability(hotelName)
        .flatMap(response -> Observable
            .from(availabilityResponse.hotelAvailabilities())
            .filter(availability -> availability.hotelInfo() != null)
            .toList()
            .doOnNext(availabilityResponse::setHotelAvailabilities)
            .map(any -> response)
        )
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());