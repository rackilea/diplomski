/**
     * Setting an instrumentation key:
     * First we try the system property '-DAPPLICATION_INSIGHTS_IKEY=i_key' or '-DAPPINSIGHTS_INSTRUMENTATIONKEY=i_key'
     * Next we will try the environment variable 'APPLICATION_INSIGHTS_IKEY' or 'APPINSIGHTS_INSTRUMENTATIONKEY'
     * Next we will try to fetch the i-key from the ApplicationInsights.xml
     * @param userConfiguration The configuration that was represents the user's configuration in ApplicationInsights.xml.
     * @param configuration The configuration class.
     */
    private void setInstrumentationKey(ApplicationInsightsXmlConfiguration userConfiguration, TelemetryConfiguration configuration) {
        try {
            String ikey;

            // First, check whether an i-key was provided as a java system property i.e. '-DAPPLICATION_INSIGHTS_IKEY=i_key', or '-DAPPINSIGHTS_INSTRUMENTATIONKEY=i_key'
            ikey = System.getProperty(EXTERNAL_PROPERTY_IKEY_NAME);
            if (!Strings.isNullOrEmpty(ikey)) {
                configuration.setInstrumentationKey(ikey);
                return;
            }
            ikey = System.getProperty(EXTERNAL_PROPERTY_IKEY_NAME_SECONDARY);
            if (!Strings.isNullOrEmpty(ikey)) {
                configuration.setInstrumentationKey(ikey);
                return;
            }

            // Second, try to find the i-key as an environment variable 'APPLICATION_INSIGHTS_IKEY' or 'APPINSIGHTS_INSTRUMENTATIONKEY'
            ikey = System.getenv(EXTERNAL_PROPERTY_IKEY_NAME);
            if (!Strings.isNullOrEmpty(ikey)) {
                configuration.setInstrumentationKey(ikey);
                return;
            }
            ikey = System.getenv(EXTERNAL_PROPERTY_IKEY_NAME_SECONDARY);
            if (!Strings.isNullOrEmpty(ikey)) {
                configuration.setInstrumentationKey(ikey);
                return;
            }

            // Else, try to find the i-key in ApplicationInsights.xml
            if (userConfiguration != null) {
                ikey = userConfiguration.getInstrumentationKey();
                if (ikey == null) {
                    return;
                }

                ikey = ikey.trim();
                if (ikey.length() == 0) {
                    return;
                }

                configuration.setInstrumentationKey(ikey);
            }
        } catch (Exception e) {
            InternalLogger.INSTANCE.error("Failed to set instrumentation key: '%s'", e.getMessage());
        }
    }