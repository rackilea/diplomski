/**
 * @param origList will be copied by this method so that origList can continue
 *                 to be read/write by other threads. 
 * @return list containing  decoded strings for each entry that was 
           in origList at time of copy.
 */
public List<String> decodeListOfStringSafely(List<String> origList)
        throws UnsupportedEncodingException {
    List<String> snapshotList = new ArrayList<String>(origList);
    List<String> newList  = new ArrayList<String>(); 

    for (String urlStr : snapshotList) {
      String decodedUrlStr  = URLDecoder.decode(urlStr, "UTF8");
          newList.add(decodedUrlStr);
    }

    return newList;
}