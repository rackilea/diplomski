@ApplicationPath("/rest")
        public class JaxRsActivator extends Application {

        @Override
            public Set<Class<?>> getClasses() {
                final Set<Class<?>> resources = new HashSet<Class<?>>();
                resources.add(MultiPartFeature.class);
                return resources;
            }

            @Override
            public Map<String, Object> getProperties() {
                Map<String, Object> properties = new HashMap<>();
                String array[] = {"com. myBean.home","com. myBean.upload","com.bandyer.search","com.bandyer.mail"};
                properties.put("jersey.config.server.provider.packages", array);
            }
        }