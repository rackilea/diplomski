try{
       JSONObject jObject = new JSONObject(response.body().getFlagReport().getMap());
            Iterator<?> keys = jObject.keys();
        while( keys.hasNext() ){
            String key = (String)keys.next();
            boolean value = jObject.getBoolean(key); // I get an error here
            SpannableString ss = new SpannableString(key);//text to change color
            ss.setSpan(new ForegroundColorSpan(value ? Color.BLUE: Color.RED), 0, ss.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            flagName.append(ss);
        }
    }catch(JSONException e){
       e.printStacktrace();
    }