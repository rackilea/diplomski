public static List<String> convertJSONtoArrayList(File f) {
    ByteBuffer buffer = ByteBuffer.allocate(f.length());
    try {
        ReadableByteChannel channel = Channels.newChannel(new FileInputStream(f));
        channel.read(buffer);
        channel.close();
    } catch (Exception e) {
        e.printStackTrace();
        return Collections.emptyList();
    }

    final String jsonString = new String(buffer.array());

    try {
        JSONArray jsonArray = new JSONArray(jsonString);
        int arrayLength = jsonArray.length();
        final List<String> result = new ArrayList<String>(arrayLength);
        for (int i = 0; i < arrayLength; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            result.add(jsonObject.getString(Tags.VALUE));
        }
        return result;
    } catch (Exception e) {
        e.printStackTrace();
        return Collections.emptyList();
    }
}