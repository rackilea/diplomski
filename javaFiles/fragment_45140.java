CREATE FUNCTION topFinal (state map<text, double>)
CALLED ON NULL INPUT
RETURNS map<text, double>
LANGUAGE java AS '
    java.util.Map<String, Double> inMap = new java.util.HashMap<String, Double>(),
                                  outMap = new java.util.HashMap<String, Double>();

    inMap.putAll(state);

    int topN = 2;
    for (int i = 1; i <= topN; i++) {
        double maxVal = -1;
        String moveKey = null;
        for (java.util.Map.Entry<String, Double> entry : inMap.entrySet()) {

            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                moveKey = entry.getKey();
            }
        }
        if (moveKey != null) {
            outMap.put(moveKey, maxVal);
            inMap.remove(moveKey);
        }
    }

    return outMap;
';