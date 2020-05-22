public abstract class BaseGetRequest<L extends List<T>, T, V> extends RetrofitSpiceRequest<L, V> implements FilterableRequest {
    // Context
    protected Context mContext;
    // Filter used in request and in queries
    protected Map<Property, String> mFilterMap;
    // Session provided Singletone
    protected DaoSessionProvider mSessionProvider;

    public BaseGetRequest(Class<L> clazz, Class<V> retrofitedInterfaceClass, Context context, Map<Property, String> filterMap) {
        super(clazz, retrofitedInterfaceClass);
        mContext = context;
        mFilterMap = filterMap;
        mSessionProvider = ((DaoSessionProvider) mContext.getApplicationContext());
        // TODO determine required retry count
        setRetryPolicy(new RetryPolicy() {
            @Override
            public int getRetryCount() {
                return 0;
            }

            @Override
            public void retry(SpiceException e) {

            }

            @Override
            public long getDelayBeforeRetry() {
                return 0;
            }
        });
    }

    protected WhereCondition[] getWhereConditions() {
        return QueryUtils.convertPropertyMapToConditionalArray(mFilterMap);
    }

    public BaseGetRequestV2(Class<L> clazz, Class<V> retrofitedInterfaceClass, Context context) {
        this(clazz, retrofitedInterfaceClass, context, null);
    }

    public abstract AbstractDao<T, Long> getDao();

    public abstract L createDataList(List<T> list);

    public L getCachedData() {
        if (mFilterMap != null && mFilterMap.size() > 0) {
            WhereCondition[] whereConditions = getWhereConditions();
            return createDataList(getDao().queryBuilder().where(whereConditions[0], Arrays.copyOfRange(whereConditions, 1, whereConditions.length)).list());
        } else {
            return createDataList(getDao().loadAll());
        }
    }

    public abstract L getData();

    @Override
    public Map<Property, String> getFilterMap() {
        return mFilterMap;
    }

    public Map<String, String> getStringMap() {
        return QueryUtils.convertPropertyMapToString(mFilterMap);
    }

    @Override
    public L loadDataFromNetwork() throws Exception {
        L receivedData = null;
        try {
            receivedData = getData();
            WhereCondition[] conditions = getWhereConditions();
            getDao().queryBuilder().where(conditions[0],Arrays.copyOfRange(conditions, 1, conditions.length)).buildDelete().executeDeleteWithoutDetachingEntities();
            getDao().insertOrReplaceInTx(receivedData);
        } catch (Exception ex) {
            receivedData = getCachedData();
        }
        return receivedData;
    }
}