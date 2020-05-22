public JSONObject parse_OS_Vuln_data_to_Json() {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        if (list_of_OS_VulnerabilityOS.size()>0) {
            for (int i = 0; i < list_of_OS_VulnerabilityOS.size(); i++) {
                WhateverTheTypeIs currentOSVulnerability = list_of_OS_VulnerabilityOS.get(i);
                JSONObject formDetailsJson;

                if (currentOSVulnerability .getList_of_ports().size() > 1) {
                    for (int v = 0; v < list_of_OS_VulnerabilityOS.get(i).getList_of_ports().size(); v++) {
                        formDetailsJson = new JSONObject() // Here's the fix: assign inside of the loop, so it's a new instance
                        formDetailsJson.put("host", currentOSVulnerability.getDest());
                        formDetailsJson.put("port", currentOSVulnerability.getList_of_ports().get(v));
                        formDetailsJson.put("open", currentOSVulnerability.isOpen());
                        formDetailsJson.put("info", currentOSVulnerability.getInfo());
                        jsonArray.add(formDetailsJson);
                        total_hostNumber_OS++;
                    }
                } else {
                    formDetailsJson = new JSONObject();
                    formDetailsJson.put("host", currentOSVulnerability.getDest());
                    formDetailsJson.put("port", currentOSVulnerability.getPorts___port());
                    formDetailsJson.put("open", currentOSVulnerability.isOpen());
                    formDetailsJson.put("info", currentOSVulnerability.getInfo());
                    jsonArray.add(formDetailsJson);
                    total_hostNumber_OS++;
                }
            }
            responseDetailsJson.put("data", jsonArray);
            System.out.print("\n list size: " + list_of_OS_VulnerabilityOS.size());
            System.out.print("\n total of OS-host to be send : " + total_hostNumber_OS);
        }
        return responseDetailsJson;
    }