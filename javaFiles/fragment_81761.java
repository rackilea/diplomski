String separatedByComma = 
    strings.stream()
           .flatMap(word -> occList.stream()
                                   .filter(occ -> word.equalsIgnoreCase (occ.getOccSCd()))
                                   .map (occ -> occ.getOccSNm()))
           .collect(Collectors.joining (","));