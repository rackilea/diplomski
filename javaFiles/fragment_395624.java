import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import org.json.JSONObject;

    BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
                String jsonR = "";
                if (br != null) {
                    jsonR = br.readLine();
                }
                JSONObject data = new JSONObject(jsonR);
                Long myId = data.getLong("myId");