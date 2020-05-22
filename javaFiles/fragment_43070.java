if ((paramName != null ) && (paramVal != null))
    {
        parameters = paramName[0] +"="+ paramVal[0];
        URLEncoder.encode(parameters, "UTF-8").replace("+", "%20");
        for (int i = 1; i < paramName.length; i++) 
        {
            parameters+= "&";
            parameters += URLEncoder.encode(paramName[i], "UTF-8").replace("+", "%20") + "=" + URLEncoder.encode(paramVal[i], "UTF-8").replace("+", "%20");
            //parameters += paramName[i] + "=" + paramVal[i];
        }
    }