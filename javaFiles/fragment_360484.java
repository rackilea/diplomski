String data = "{\"status\":\"OK\",\"masterlist\":{    \"session\":{        \"session_id\":1007,        \"session_name\":\"97th Legislature\"    },    \"0\":{        \"bill_id\":446875,        \"number\":\"HB4001\"    },    \"1\":{        \"bill_id\":446858,         \"number\":\"HB4002\"    },    \"2\":{        \"bill_id\":446842,        \"number\":\"HB4003\"    }}}";
        Gson gson = new Gson();         
        ResponseData response = gson.fromJson(data, ResponseData.class);

        for (Iterator<Entry<String, MasterList>> it = response.getMasterlist().entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, MasterList> entry = it.next();
            System.out.println(entry.getKey());
System.out.println(entry.getValue().getSession_id());
        }