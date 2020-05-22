new JsonObjectRequest(url, jsonRequest, listener, errorListener) {

        @Override
        public Map<String, String> getHeaders() {

            Map<String, String> map = new HashMap<String, String>();
            map.put("X-REST-API-Key", resources.getString(R.string.parse_api_key));
            map.put("X-Application-id",
                    resources.getString(R.string.application_id));

            if (sessionToken != null) {
                map.put("X-Session-Token", sessionToken);
            }

            return map;
        }
    };