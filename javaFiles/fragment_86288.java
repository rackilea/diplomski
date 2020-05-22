ConfigurationListener listener = new ConfigurationListener() {

        @Override
        public void configurationChanged(ConfigurationEvent event) {
            if ( !event.isBeforeUpdate() ){
                System.out.println(event.getPropertyName() + " " + event.getPropertyValue());
            }
        }
    };
    configuration.addConfigurationListener(listener);