import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParserWithJsonOrg {

    private static final String COLUMN_DELIMITER = "|";

    private static final String LINE_DELIMITER = "\r\n";

    public String parse(String input) {

        StringBuilder output = new StringBuilder();

        String json1String = input.substring(0, input.indexOf("}") + 1).trim();
        String json2String = input.substring(input.indexOf("}") + 1).trim();

        JSONObject json1Tree = new JSONObject(json1String);
        JSONObject json2Tree = new JSONObject(json2String);

        JSONObject statDataRequestNode = json2Tree.getJSONObject("StatDataRequest");
        JSONObject statsNode = statDataRequestNode.getJSONObject("stats");
        JSONArray clientStatArray = statsNode.getJSONArray("clientStat");

        String header = createHeaderData(json1Tree, json2Tree);

        for (int i = 0; i < clientStatArray.length(); i++) {

            JSONObject clientStatNode = clientStatArray.getJSONObject(i);

            JSONObject contentActionStatNode = clientStatNode.getJSONObject("contentActionStat");

            output.append(header);

            output.append(getContent(contentActionStatNode, "progid"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "gen1re"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "rating"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "vendor"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "vod"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "ppv"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "series"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "title"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "description"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "recordDate"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "channel"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "channel_name"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "TMSID"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "channel_minor"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "hd"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "contentAction"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "clientMode"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "durationSeconds"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "timestamp"));
            output.append(COLUMN_DELIMITER);

            output.append(getContent(contentActionStatNode, "errorReason"));

            output.append(LINE_DELIMITER);
        }

        return output.toString();
    }

    private Object getContent(JSONObject jsonObject, String key) {

        Object object = null;

        try {
            object = jsonObject.get(key);
        } catch (JSONException e) {
            object = "";
        }

        return object;
    }

    private String createHeaderData(JSONObject json1Tree, JSONObject json2Tree) {

        StringBuilder builder = new StringBuilder();

        builder.append(getContent(json1Tree, "objectKey"));
        builder.append(COLUMN_DELIMITER);

        JSONObject statDataRequestNode = json2Tree.getJSONObject("StatDataRequest");

        builder.append(getContent(statDataRequestNode, "protocolVersion"));
        builder.append(COLUMN_DELIMITER);

        builder.append(getContent(statDataRequestNode, "platform"));
        builder.append(COLUMN_DELIMITER);

        builder.append(getContent(statDataRequestNode, "format"));
        builder.append(COLUMN_DELIMITER);

        builder.append(getContent(statDataRequestNode, "deviceid"));
        builder.append(COLUMN_DELIMITER);

        return builder.toString();
    }

    public static void main(String[] args) throws IOException {

        String input = "{\"objectKey\":\"trx/Phone/2016-05-12/15-12-18/0384bdr311-32w5b-49aa-a814-379256f80ca8\"}   {\"StatDataRequest\":{\"protocolVersion\":\"1\",\"platform\":\"Android\",\"format\":\"Detailed\",\"deviceid\":\"0384bdr311-32w5b-49aa-a814-379256f80ca8\",\"stats\":{\"clientStat\":[{\"contentActionStat\":{\"progid\":\"56aa31a135d1c95d77f70b533289dfc3\",\"gen1re\":\"Sports/Auto/Racing/High-Def/Events/Series/Live\",\"rating\":\"0\",\"vendor\":\"1 1 877U3 50B\",\"vod\":\"false\",\"ppv\":\"false\",\"series\":\"true\",\"title\":\"Test Prix, Practice\",\"description\":\"\\\"Test Prix, Practice\\\"\",\"recordDate\":\"2016-05-26T12:00:00Z\",\"channel\":\"220\",\"channel_name\":\"NBCSHD\",\"TMSID\":\"ABCD5544671291\",\"channel_minor\":\"0\",\"hd\":\"false\",\"contentAction\":\"Streaming_Started\",\"clientMode\":\"UNKNOWN\",\"timestamp\":\"2016-05-27T03:00:28.686Z\",\"errorReason\":\"36100530\"}},{\"contentActionStat\":{\"progid\":\"56aa31a135d1c95d77f70b533289dfc3\",\"gen1re\":\"Sports/Auto/Racing/High-Def/Events/Series/Live\",\"rating\":\"0\",\"vendor\":\"1 1 875E3 50B\",\"vod\":\"false\",\"ppv\":\"false\",\"series\":\"true\",\"title\":\"Test Prix, Practice\",\"description\":\"\\\"Test Prix, Practice\\\"\",\"recordDate\":\"2016-05-26T12:00:00Z\",\"channel\":\"220\",\"channel_name\":\"NBCSHD\",\"TMSID\":\"ABCD5544671291\",\"channel_minor\":\"0\",\"hd\":\"false\",\"contentAction\":\"Streaming_Stopped\",\"clientMode\":\"UNKNOWN\",\"durationSeconds\":\"3172\",\"timestamp\":\"2016-05-27T03:53:20.077Z\",\"errorReason\":\"36100530\"}}]}}}";

        ParserWithJsonOrg parser = new ParserWithJsonOrg();
        String output = parser.parse(input);

        System.out.println(output);
    }
}