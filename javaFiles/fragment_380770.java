public class DistrubutedMapStats implements Callable<String>, Serializable,HazelcastInstanceAware{

private static final long serialVersionUID = 1L;
String cacheMapName = null;
// 0 means no heap Cost.
/** The heap Cost. */
protected long heapCost = 0;    
protected long totalHeapCost = 0;
protected long backupHeapCost = 0;
public transient HazelcastInstance hazelcastInstance;



public DistrubutedMapStats() {
}

public DistrubutedMapStats(String cacheMapName) {
    this.cacheMapName = cacheMapName;   
}

public String call() {  

    LocalMapStats mapStatistics = hazelcastInstance.getMap(cacheMapName).getLocalMapStats();
    heapCost = mapStatistics.getHeapCost();
    backupHeapCost=mapStatistics.getBackupEntryMemoryCost();

    totalHeapCost=heapCost-backupHeapCost;
    System.out.println("CacheName="+cacheMapName+" Total Cost="+heapCost+" HeapCost="+totalHeapCost+" BackupHeapCost="+backupHeapCost+" from Member");
    return  ""+totalHeapCost;
}

@Override
public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
    // TODO Auto-generated method stub
    this.hazelcastInstance=hazelcastInstance;
}