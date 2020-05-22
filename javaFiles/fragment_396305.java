resolution = new RedirectResolution(reponseUrl);
            Iterator<Map.Entry<String, String[]>> requestParamter = ctx.getRequest().getParameterMap().entrySet().iterator();
            List<IdName> requestParams = new ArrayList<IdName>();
            while(requestParamter.hasNext()){
                IdName param = new IdName();
                Map.Entry<String, String[]> entry = requestParamter.next();
                param.setName(entry.getKey());
                param.setParameterValues(entry.getValue());
                log.trace("intercept - Adding Key: {} with value: {} to redirect request parameter.", entry.getKey(), entry.toString() );
                requestParams.add(param);
            }
            ctx.setRedirectRequestParameter(requestParams);