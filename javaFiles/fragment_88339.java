static Handler getHandler(Class<?> handlerClass)
        {
            if(handlerClass.isInstance(Project.class))
            {
                //return ProjectHandler
            }else if(handlerClass.isInstance(Time.class))
            {
                //return TimeHandler
            }
            //return errorHandler
        }
        interface Handler {
            int handle();
        }
       public static <T> int update(List<T> objects){
            for(T object : objects)
            {
                getHandler(object.getClass()).handle();
            }
            return 0;
        }