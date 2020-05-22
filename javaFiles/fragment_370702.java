public static String getFormatStringFromList(ArrayList<String> data) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < data.size(); i++) {
        sb.append(data.get(i) + ";");   
    }

    return sb.toString();
    //eg. 0 item;1 item;2 item;3 item;4 item;
}