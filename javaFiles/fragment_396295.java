class StrategyFactory {

  private Strategy defaultStrategy = new Function2();

  Map<String, Strategy> strategies = ....
  strategies.put("abc", new Function1());
  ...

  Strategy getStrategy(String key) {
     return strategies.getOrDefault(key, defaultStrategy);
  }
}