public enum Type {

    PROCESS_CATY(new PoolSizes().withStagePoolSize(5).withProductionPoolSize(8), 
        DataCenter.NA, false), 
    PROCESS_MISC1(new PoolSizes().withStagePoolSize(5).withProductionPoolSize(8), 
        DataCenter.NA, false), 
    LINK_ENTRY(new PoolSizes().withStagePoolSize(5).withProductionPoolSize(12), 
        DataCenter.NA, true),

    ABC_RAW_PHO(new PoolSizes().withProductionPoolSize(123), DataCenter.PHO, true),
    ABC_RAW_SLQ(new PoolSizes().withProductionPoolSize(123), DataCenter.SLQ, true),
    ABC_RAW_LVK(new PoolSizes().withProductionPoolSize(123), DataCenter.LVK, true),

    ABC_RAW_PIN_PHO(new PoolSizes().withProductionPoolSize(123), DataCenter.PHO, true),
    ABC_RAW_PIN_SLQ(new PoolSizes().withProductionPoolSize(123), DataCenter.SLQ, true),
    ABC_RAW_PIN_LVK(new PoolSizes().withProductionPoolSize(123), DataCenter.LVK, true);

    private final PoolSizes poolSizes;
    private final DataCenter dataCenter;
    private final boolean enabled;

    private Type(PoolSizes poolSizes, DataCenter dataCenter, boolean enabled) {
      this.poolSizes = poolSizes;
      this.dataCenter = dataCenter;
      this.enabled = enabled;
    }

    public int getPoolSize(Environment environment) {
      return poolSizes.getPoolSize(environment);
    }

    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public boolean isEnabled(Environment environment, DataCenter dataCenter) {
      return enabled && poolSizes.getPoolSize(environment) != PoolSizes.SIZE_UNDEFINED 
              && (getDataCenter() == DataCenter.NA || getDataCenter() == dataCenter);
    }
  }