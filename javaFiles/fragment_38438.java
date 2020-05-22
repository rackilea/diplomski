Logger logger = LoggerFactory.getLogger(HttpUtil.class);
HttpLoggingInterceptor logging =
    new HttpLoggingInterceptor((msg) -> {
        logger.debug(msg);
    });
logging.setLevel(Level.BODY);

client.addNetworkInterceptor(logging);