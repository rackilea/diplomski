CriteriaQuery<TopUpRAMSInfo> data = cb.createQuery(TopUpRAMSInfo.class);
Root<TopUpRAMS> c = data.from(TopUpRAMS.class);
data.select(cb.construct(TopUpRAMSInfo.class,
        c.get("deviceId"), 
        cb.sum(c.get("rechargeValue"))
    )
);