public String sha(String script) {
  String shaDigest = redisScriptingCommands.digest(script);
  boolean scriptExists = redisScriptingCommands.scriptExists(shaDigest).get(0);
  if (!scriptExists) {
    redisScriptingCommands.scriptLoad(script);
  }
  return shaDigest;
}