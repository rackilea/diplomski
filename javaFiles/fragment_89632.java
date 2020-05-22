Response response = httpCommandExecutor.execute (new Command (newSessionId, "getAllSessions"));

// Don't kill the new session
for (HashMap<String, Object> sessionParams : (ArrayList<HashMap<String, Object>>) response.getValue ()) {
    SessionId sessionId = new SessionId ((String) sessionParams.get("id"))
    if (!newSessionId.equals(sessionId)){
        httpCommandExecutor.execute (new Command (sessionId, "quit"));
    }
}