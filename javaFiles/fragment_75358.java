HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance(null);
Collection<Instance> instances = hzInstance.getInstances();
Set<Instance> locks = new HashSet<Instance>();
for (Instance inst : instances) {
    if(inst.getInstanceType().equals(Instance.InstanceType.LOCK))
    locks.add(inst);
}