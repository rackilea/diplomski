public class RSFCachingMQQueueConnectionFactoryFactory implements ObjectFactory{

public Object getObjectInstance (Object obj, Name name, Context nameCtx, Hashtable<?,?> environment)
    throws NamingException {
            Reference ref = (Reference) obj;
            String beanClassName = ref.getClassName();
            Class<?> beanClass = Class.forName(beanClassName);
            if (CachingConnectionFactory.class.isAssignableFrom(beanClass)){
                MQQueueConnectionFactoryFactory cff = new MQQueueConnectionFactoryFactory();
                Reference mqReference = new Reference(
                        MQQueueConnectionFactory.class.getName());

                Enumeration<RefAddr> allAddrs = ref.getAll();
                while (allAddrs.hasMoreElements()){
                    mqReference.add(allAddrs.nextElement());
                }

                MQQueueConnectionFactory cf = (MQQueueConnectionFactory)cff.getObjectInstance(mqReference, name, nameCtx, environment);
                CachingConnectionFactory ccf = (CachingConnectionFactory)beanClass.newInstance();
                ccf.setTargetConnectionFactory(cf);
                return ccf;
            }
        }