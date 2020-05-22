if ((request != null) && (request.getSession() != null) &&
            (request.getSession().getAttribute(SPRING_SECURITY_SAVED_REQUEST) != null) ){
        savedRequest = (SavedRequest) request.getSession().getAttribute(SPRING_SECURITY_SAVED_REQUEST);
        request.getSession().setAttribute(ORIG_SAVED_REQUEST_URL, savedRequest.getRedirectUrl());
        request.getSession().setAttribute(ORIG_SAVED_REQUEST, savedRequest);
        logger.debug("Session Variable ORIG-SAVED-REQUEST={}",savedRequest.getRedirectUrl());
    }