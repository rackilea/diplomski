ArrayList<String> clientXSLList = (ArrayList<String>) session
                    .getAttribute("ClientXSL");
            if (clientXSLList != null) {

                hmURI_SessionAttrLMap.put(uri, clientXSLList.clone());
            }