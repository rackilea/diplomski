@Override
   public Map<String, Object> getComponentConfiguration() {
      // configure how often a tick tuple will be sent to our bolt
     Config conf = new Config();
     conf.put(Config.TOPOLOGY_TICK_TUPLE_FREQ_SECS, topology_tick_tuple_freq_secs);
        return conf;
   }