private static AmazonServices amazonServices = null;
    private static PurpleServices purpleServices = null;

    static OkHttpClient.Builder httpClient = getUnsafeOkHttpClient();

    private static Retrofit.Builder builder = new Retrofit.Builder();

    public static <S> S createService(Class<S> serviceClass) {

        S mAPI = null;
        if (serviceClass.getSimpleName().equals("PurpleService")) {
            if (purpleServices == null) {
                purpleServices = (PurpleServices) createPurpleAPI(serviceClass);
            }
            mAPI = (S) purpleServices;
        } else if (serviceClass.getSimpleName().equals("AmazonServices")) {
            if (amazonServices == null) {
                amazonServices = (AmazonServices) createAmazonAPI(serviceClass);
            }
            mAPI = (S) amazonServices;
        }
        return mAPI;
    }