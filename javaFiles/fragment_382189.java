List<Video> getVideoList() {
List<Video> list = new ArrayList<Video>();

try {
    ResultSet res = stmt.executeQuery("SELECT VidID, Name, Writer FROM Items ORDER BY VidID ASC");
    while (res.next()) { // there is a result
        Video sub = new Video();
        sub.vidID = res.getString("VidID");
        sub.name = res.getString("Name");
        sub.writer = res.getString("Writer");
        list.add(sub); 
    }
        res.close();
} catch (Exception e) {
    System.out.println(e);
    return null;
}

return list;
}