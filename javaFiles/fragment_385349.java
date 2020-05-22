List<String> clientXSLList = (List) session
                    .getAttribute("ClientXSL");
            if (clientXSLList != null) {

                hmURI_SessionAttrLMap.put(uri, clientXSLList);
            }