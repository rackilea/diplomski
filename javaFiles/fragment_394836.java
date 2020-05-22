public static String getPostDataString(HashMap<Object, Object> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<Object, Object> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey().toString()));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue().toString()));
        }

        return result.toString();
    }