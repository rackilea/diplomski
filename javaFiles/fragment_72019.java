SavedRequest savedRequest = null;
        if (request.getSession().getAttribute(ORIG_SAVED_REQUEST_URL) != null){
            saveURL = request.getSession().getAttribute(ORIG_SAVED_REQUEST_URL).toString();
            savedRequest = (SavedRequest) request.getSession().getAttribute(ORIG_SAVED_REQUEST);
            request.getSession().setAttribute(ORIG_SAVED_REQUEST_URL, saveURL);
            request.getSession().setAttribute(ORIG_SAVED_REQUEST, savedRequest);
            request.getSession().setAttribute(SPRING_SECURITY_SAVED_REQUEST, savedRequest);
            logger.debug("Session Variable ORIG-SAVED-REQUEST={}",savedRequest.getRedirectUrl());
        }