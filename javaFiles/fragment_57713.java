public class TKNDataServiceImpl implements TKNDataService {

    private static final Logger LOG = LoggerFactory.getLogger(TKNDataServiceImpl.class);

    private TKNDatabase tknDb = null;

    @Override
    public boolean isTKNDataServiceAvailable() {
        return tknDb.isAvailable();
    }

    @Override
    public TknLocator getTokenLocatorForCustomerKey(String custkey) throws TKNDataServiceUnavailableException,
            TKNDataServiceInvalidDataException {

        if (null != custkey) {

            final String token = tknDb.getAccessToken(custkey);
            Timestamp expiry = tknDb.getExpiry(custkey);
            LOG.info("ACCESS TOKEN: " + token);
            LOG.info("EXPIRY: " + expiry);
            TknLocator loc = new TknLocator();
            loc.setAccess_token(token);
            loc.setexpires_in(expiry);

            return loc;
        }

        return null;
    }

    @Override
    public boolean CustomerKeyExistsInTokenDb(String custkey) throws TKNDataServiceInvalidDataException,
            TKNDataServiceUnavailableException {

        boolean keyExists = tknDb.doesCustKeyExist(custkey);
        return keyExists;
    }

    @Override
    public void TknDbAddRow(String custkey, String access_token, int expires_in) { 
        if (null != custkey) {
            tknDb.addRow(custkey, access_token, expires_in);
        }
    }

    @Override
    public void TknReplicationComplete() { 
        tknDb.replicationComplete();
    }

    @Override
    public void TknDropRow(String custkey) { 
        if (null != custkey) {
            tknDb.dropRow(custkey);
        }
    }

    public Timestamp TknGetExpiry(String custkey) throws TKNDataServiceUnavailableException, 
                TKNDataServiceInvalidDataException {

        return(tknDb.getExpiry(custkey));
    }

    public String TknGetAccessToken(String custkey) throws TKNDataServiceUnavailableException,
            TKNDataServiceInvalidDataException {

        return(tknDb.getAccessToken(custkey));
    }


    public void settknDatabase(TKNDatabase tknDb) {
        this.tknDb = tknDb;
    }

}