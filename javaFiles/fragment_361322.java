String json = "{\n"
            + "  \"toptracks\" : {\n"
            + " \"track\": [{\n"
            + "     \"name\": \"Best I Ever Had\",\n"
            + "     \"playcount\": \"3551414\",\n"
            + "     \"listeners\": \"1058277\",\n"
            + "     \"mbid\": \"00bde944-7562-446f-ad0f-3d4bdc86b69f\",\n"
            + "     \"url\": \"https://www.last.fm/music/Drake/_/Best+I+Ever+Had\",\n"
            + "     \"streamable\": \"0\",\n"
            + "     \"artist\": {\n"
            + "         \"name\": \"Drake\",\n"
            + "         \"mbid\": \"b49b81cc-d5b7-4bdd-aadb-385df8de69a6\",\n"
            + "         \"url\": \"https://www.last.fm/music/Drake\"\n"
            + "     }\n"
            + " }]\n"
            + "}\n"
            + "}";

    ObjectMapper mapper = new ObjectMapper();

    TopTracks track = mapper.readValue(json, TopTracks.class);

    List<Object> trackList = (List<Object>)track.toptracks.get("track");

    Map<String, Object> trackMap = (Map<String, Object>) trackList.get(0);

    System.out.println(trackMap.get("name"));

public class TopTracks {

    public Map<String, Object> toptracks = new HashMap<>();
}