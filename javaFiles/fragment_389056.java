for(UserMatchInfo tmpUserMatchInfo : userMatchInfoList){
    String teamFollowedByUser = tmpUserMatchInfo.getSupportingTeam();
    Match matchWhichUserFollows = tmpUserMatchInfo.getMatch();
    if(matchMap.get(matchWhichUserFollows.getMatchId().intValue()) {
        //... etc.

    }
}