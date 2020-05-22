public void saveToLeaderboard() throws IOException {
        String toSave = "Data to save";
        InputStream inputStream = null;
        HttpConnection connection = (HttpConnection) Connector.open("External Url" + "?info=" + toSave, Connector.READ_WRITE, true);
        connection.setRequestMethod(HttpConnection.POST);
        inputStream = connection.openInputStream();
        inputStream.close();
        connection.close();
    }