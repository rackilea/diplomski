String logContent = pushToPlayers(getPlayersFromUser(o,pushManagerDB),content,data,page);
HashMap<String, Object> map = new HashMap<>();
if (logContent != null) {
  map.put("content", logContent);
}
pushManagerDB.insert("log_notifiche", map);