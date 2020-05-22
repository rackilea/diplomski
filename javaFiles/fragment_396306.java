if(ctx.getRedirectRequestParameter() != null && !ctx.getRedirectRequestParameter().isEmpty()){
                //Removes parameter which are already in request from redirect request parameter.
                Map<String, String[]> additionalParams = new TreeMap<String, String[]>();
                Map requestParameterMap = ctx.getRequest().getParameterMap();
                ListIterator<IdName> oldRequestParams = ctx.getRedirectRequestParameter().listIterator();
                while(oldRequestParams.hasNext()){
                    IdName oldRequestParam = oldRequestParams.next();
                    log.trace("Lopping requestparameter key: {} ", oldRequestParam.getName() );
                    if (!requestParameterMap.containsValue(oldRequestParam.getName())) {
                        additionalParams.put(oldRequestParam.getName(), oldRequestParam.getParameterValues());
                    }
                }
                HttpServletRequest newRequest = new MyperksHttpServletRequestWrapper(ctx.getRequest(), additionalParams);
                ctx.setRequest(newRequest);
                ctx.setRedirectRequestParameter(null);
            }