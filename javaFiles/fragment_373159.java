public Map<String, TeamInfo> parseTeamInfo(String inputFile) {
    Map<String, TeamInfo> teamInfo = null;
    try {
        TypeReference<HashMap<String,TeamInfo>> typeRef 
            = new TypeReference<HashMap<String,TeamInfo>>() {};

        HashMap<String,TeamInfo> o = mapper.readValue(inputFile, typeRef); 
    } catch (IOException e) {
        e.printStackTrace();
    }
    return teamInfo;
}