if (hrefAttr != null && hrefAttr.contains("?")) {
            String[] splitHref = hrefAttr.split("\\?");
            String URL = splitHref[0];
            linkConcat = QA_ID + "_" + URL;
        } else {
            linkConcat = QA_ID + "_" + hrefAttr;
        }