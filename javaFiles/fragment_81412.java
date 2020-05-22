StringBuilder sb = new StringBuilder();
  for(HashMap.Entry<String, String> e : queryString.entrySet()){
      if(sb.length() > 0){
          sb.append('&');
      }
      sb.append(URLEncoder.encode(e.getKey(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue(), "UTF-8"));
  }