private HotelResult findHotelResult(List<HotelResult> hotelResultsList, HotelSelection hotelSelection) {
    Optional<HotelResult> found = hotelResultsList.stream().filter((r) -> {
        Optional<RoomRateIds> optId = r.getRoomOptions().stream().flatMap(o -> o.getRoomTypeIds().stream())
                .flatMap(rate -> rate.getRoomRateIds().stream())
                .filter(id -> id.getId().equals(hotelSelection.getResultId())).findFirst();
        return optId.isPresent();
    }).findFirst();

    return found.orElse(null);
}