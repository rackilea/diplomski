for (int code ; 0 <= (code = codes.read()) ; ) {
        String entry = (String) dictionary.get(code);
        w += (null != entry ? entry : w).charAt(0);
        dictionary.put(++currentDictSize, w);
        result.append(w = entry);
    }