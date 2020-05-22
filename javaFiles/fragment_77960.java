public Iterable<Long> convertToLong(final String ids){
    String[] idArray = ids.split(",");
    List<Long> idsAsLong = new ArrayList<>();
    for (int i = 0; i < idArray.length; i++) {
        idsAsLong.add(Long.parseLong(idArray[i]));
    }
    return idsAsLong;
}