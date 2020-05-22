@Override
public void onDatabaseChangeNotification(oracle.jdbc.dcn.DatabaseChangeEvent e) 
{
    synchronized(adRep) {
        cachedAd = adRep.findByKey(1L);
    }
    DecLogger.DEC_LOGIN.finer(() -> "Oracle DCN Call on Admin Data - Invalidating Cached Data");
}

@PostConstruct
private void setInitialValue()
{
    synchronized(adRep) {
        cachedAd = adRep.findByKey(1L);
    }
    DecLogger.DEC_LOGIN.finer(() -> "AdminDataCacher - Initial value set");
}