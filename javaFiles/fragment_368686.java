private void loadUserRequest() {
    GetUserListRequest req = new GetUserListRequest();
    req.setListener(this);
    try {
        transcription.Main.cq.addRequest(req);
    } catch (NullPointerException e) {}
}