listRoomsCall
.flatMap(v -> 
     Observable.fromIterable(v.getExchangeRoomList())
     .flatMap(exchangeRoom -> {
         mMeetingServiceApi.listMeetings(roomID, startsAtString, endsAtString, free);
     })
)
.subscribe(/* */);