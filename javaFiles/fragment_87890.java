List<List<Object>> partList = myParsedObject.getParts();
    if (partList.size() > 0) {
        if (partList.get(0).size() > 1) {
            if (partList.get(0).get(1) instanceof String) {
                return partList.get(0).get(1).toString();
            }
        }
    }