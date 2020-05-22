userLoginsToPersist
  .stream()
  .map(login ->
        Arrays.asList(login.getUsername(), login.getIp(), login.getMac(), login.getLogin(), login.getStatus(), login.getApplication(), login.getEntertainmentCredentialsId(), login.getVersion())
  ).reduce(userLoginBatch, (b, v) -> b.bind(v), (b1, b2) -> b1)
  .execute();