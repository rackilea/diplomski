public static ExecutionEnvironment setupLocalEnvironment() {
     Configuration conf = new Configuration();
      env = new LocalEnvironment(conf);
      env.getConfig().disableSysoutLogging();
      return env;
}