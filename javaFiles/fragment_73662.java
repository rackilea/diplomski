AuthorizationPolicy policy = message.get(AuthorizationPolicy.class);

    if (policy == null) {
        sendErrorResponse(message, HttpURLConnection.HTTP_UNAUTHORIZED);
        return;
    }


    message.put("request_usr", policy.getUserName());
    message.put("request_pwd", policy.getPassword());