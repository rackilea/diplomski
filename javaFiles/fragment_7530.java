mGeoDataClient.getAutocompletePredictions("Supermarket", null, null).addOnSuccessListener {
    it.map{ it.placeId}.filterNotNull().toTypedArray().let {
        mGeoDataClient.getPlaceById(*it).addOnSuccessListener {
            it.forEach{
                val marker = it.latLng
                val name = it.name.toString()
                mMap.addMarker(MarkerOptions().position(marker).title(name))
            }
        }
    }
}