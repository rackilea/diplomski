@Inject
public TokenUtils(@Nonnull @Configuration(BB_AUTH_PRIVATE_KEY) final String serverPrivateKey,
                      @Configuration(BB_AUTH_VALIDITY) final long validity) {
        this.serverPrivateKey = serverPrivateKey;
        this.validity = validity;

        LOGGER.info("serverPrivateKey:" + serverPrivateKey);
        LOGGER.info("validity:" + validity);
    }