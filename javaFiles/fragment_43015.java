IMap map1 = (IMap) ctx.getBean("userMapSpringId");
// map1 will make use of the configuration with name "userMap"

IMap map2 = (IMap) ctx.getBean("mangoMapSpringId");
IMap map3 = (IMap) ctx.getBean("appleMapSpringId");
// Here two different IMaps objects are created. 
// However both map2 and map3 will make use of the same configuration "FruitMap*". 

IMap map4 = (IMap) ctx.getBean("alientFruitMapSpringId");
// In the case of map4, there is no configuration which matches its hazelcast name 
// (AlienFruit). Hence it will make use of the configuration with name "default".