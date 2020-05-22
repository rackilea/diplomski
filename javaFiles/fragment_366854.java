//Singleton class: Tenant   (LOOK AT THE VOID RETURN VALUE!)
public void gAgentList(final AgentsResultCallback callback) {
    final ArrayList<GuestAgent> guestAgents = new ArrayList<>();
    String url = "http://localhost:8080/StackUI/v2.0/";
    url = url + this.tenantId;
    url = url + "/os-agents";

    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
    builder.setHeader("X-Auth-Token", this.tokenId);

    try {
        builder.sendRequest(null, new RequestCallback() {
            @Override
            public void onError(Request request, Throwable exception) {
                Window.alert("Attensione si è verificato un errore");
                callback.onCompleted(null); // call the callback with null results 
            }

            @Override
            public void onResponseReceived(Request request, Response response) {
                if (200 == response.getStatusCode()) {
                    final HTML respBox = new HTML();
                    respBox.setHTML(response.getText());

                    String risposta = response.getText();

                    JSONValue jsonValue;
                    JSONArray jsonArray;
                    JSONObject jsonObject;
                    JSONString jsonString;
                    JSONNumber jsonNumber;

                    jsonValue = JSONParser.parseStrict(risposta);

                    if ((jsonObject = jsonValue.isObject()) == null) {
                        Window.alert("Error parsing the JSON");
                    }

                    jsonValue = jsonObject.get("agents");
                    if ((jsonArray = jsonValue.isArray()) == null) {
                        Window.alert("Error parsing the JSON");
                    }

                    for (int i = 0; i < jsonArray.size(); i++) {
                        GuestAgent guestAgent = new GuestAgent();
                        jsonValue = jsonArray.get(i);

                        if ((jsonObject = jsonValue.isObject()) == null) {
                            Window.alert("Error parsing the JSON");
                        }

                        jsonValue = jsonObject.get("agent_id");
                        if ((jsonNumber = jsonValue.isNumber()) == null) {
                            Window.alert("Error parsing the JSON");
                        }
                        guestAgent.setAgentId(jsonNumber.toString());

                        jsonValue = jsonObject.get("architecture");
                        if ((jsonString = jsonValue.isString()) == null) {
                            Window.alert("Error parsing the JSON");
                        }
                        guestAgent.setArchitecture(jsonString.stringValue());

                        jsonValue = jsonObject.get("hypervisor");
                        if ((jsonString = jsonValue.isString()) == null) {
                            Window.alert("Error parsing the JSON");
                        }
                        guestAgent.setHypervisor(jsonString.stringValue());

                        jsonValue = jsonObject.get("md5hash");
                        if ((jsonString = jsonValue.isString()) == null) {
                            Window.alert("Error parsing the JSON");
                        }
                        guestAgent.setMd5hash(jsonString.stringValue());

                        jsonValue = jsonObject.get("os");
                        if ((jsonString = jsonValue.isString()) == null) {
                            Window.alert("Error parsing the JSON");
                        }
                        guestAgent.setOs(jsonString.stringValue());

                        jsonValue = jsonObject.get("url");
                        if ((jsonString = jsonValue.isString()) == null) {
                            Window.alert("Error parsing the JSON");
                        }
                        guestAgent.setUrl(jsonString.stringValue());

                        jsonValue = jsonObject.get("version");
                        if ((jsonString = jsonValue.isString()) == null) {
                            Window.alert("Error parsing the JSON");
                        }
                        guestAgent.setVersion(jsonString.stringValue());

                        guestAgents.add(guestAgent);


                    }

                        // FINISHED! results are complete so I send them to the callback
                        callback.onCompleted(guestAgents);

                } else {
                    // Handle the error.  Can get the status text from response.getStatusText()
                    Window.alert("Errore " + response.getStatusCode() + " " + response.getStatusText());
                    callback.onCompleted(null); // call the callback with null results here, too
                }
            }
        });
    } catch (RequestException e) {
        // Couldn't connect to server   
        Window.alert("Impossibile connettersi al server");
    }

    return; // return nothing!
}