private fun locationChanged(locationResult: LocationResult) {
    for (location in locationResult.locations) {

        val lat = location.latitude
        val lng = location.longitude
        var dDistanceToOffice: Double
        var dRadius: Double

        Observable.fromIterable(offices)
                .subscribeOn(Schedulers.newThread())
                .filter {
                    val dLat = it.oc_lat!!.toDouble()
                    val dLong = it.oc_long!!.toDouble()
                    dRadius = it.oc_radius!!.toDouble()

                    // Check the distance "MyLocation" to "OfficeLocation"
                    Location.distanceBetween(lat, lng, dLat, dLong, resultApi)
                    val sDistanceToOffice = resultApi[0].toString()
                    dDistanceToOffice = sDistanceToOffice.toDouble()

                    dDistanceToOffice < dRadius
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Office> {
                    override fun onSubscribe(d: Disposable) {
                        disposable = d
                    }

                    override fun onNext(office: Office) {
                        inArea = "Y"
                        siteName = office.oc_site
                        siteId = office.oc_id
                        siteLat = office.oc_lat!!
                        siteLong = office.oc_long!!
                    }

                    override fun onError(e: Throwable) {
                        Log.e(TAG, "locationChanged() Error: ${e.message}")
                    }

                    override fun onComplete() {
                        // checking the data in Area = N or Y
                        if (isMock(location)) {
                            processTheMock()
                        } else {
                            if (inArea == "Y") {
                                hideButtonOutRadius()
                                hideProgressbarPosition()
                                showButtonCheckin()
                                processNoMock(lat, lng, "In Radius", siteName!!)
                            } else {
                                retrofitGoogleGeocoding(lat, lng)
                                inArea = "N"
                                siteName = newAddress
                                siteLat = lat.toString()
                                siteLong = lng.toString()
                                hideButtonOutRadius()
                                hideProgressbarPosition()
                                showButtonCheckin()
                                processNoMock(lat, lng, "In Radius", siteName!!)
                            }
                        }
                        stopLocationUpdates()
                    }
                })
    } // end of location
}