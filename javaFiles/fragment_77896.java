public class ServiceToActivity
    {

                public ActionBarActivity mainactivity = null;
                private static ServiceToActivity singleton = null;
                public Class<?> cl = null;

                private ServiceToActivity()
                {

                }

                public static ActionBarActivity getSingleton()
                {
                    if(singleton==null)
                           return null;
                    return singleton.mainactivity;
                }

               public static Class<?> getSingletonClass()
                {
                    if(singleton==null)
                           return null;
                    return singleton.cl;
                }

                public static void setSingleton(ActionBarActivity mainactivity, Class<?> cl)
                {
                      if(singleton==null)
                             singleton = new ServiceToActivity();
                      singleton.mainactivity = mainactivity;
                      singleton.cl = cl;
                }
    }