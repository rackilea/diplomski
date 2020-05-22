listRoomsCall
.flatMapIterable(v -> v.getExchangeRoomList())
.flatMap(exchangeRoom -> {
    mMeetingServiceApi.listMeetings(roomID, startsAtString, endsAtString, free);
})
.subscribe(/* */);