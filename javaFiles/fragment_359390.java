public Mono<RoomData> findAndTryKickUser(String roomId, String requestUserId, String kickUserId){
    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(roomId).and("roomLeaderId").is(requestUserId)
            .and("userRoomDatas").elemMatch(Criteria.where("userId").is(kickUserId)));

    Update update = new Update();
    update.pull("userRoomDatas", new Query().addCriteria(Criteria.where("userId").is(kickUserId)));
    FindAndModifyOptions options = FindAndModifyOptions.options();
    options.returnNew(true);
    return template.findAndModify(query, update, options, RoomData.class);
}