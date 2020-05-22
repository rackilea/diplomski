public static class AppContext{

            //you can add the controllers by their variables 
            private Controller1 test1;
            private Controller2 test2;

            //or from a list which will require handling , but it will be more dynamic
              private List<Controller> controllers;
            private static AppContext context=null;
            //You make the constructor private so its really a sigleton ,
            //cause noone can access it from outer package
            private AppContext()
            {

            }

           public static AppContext getAppContext(){
               if(context==null)
                      context=new AppContext();
               return context;
           }

           public void setController1(Controller1 e)
           {
               test1=e;
           }

           public void setController2(Controller2 e)
           {
               test2=e;
           }

           public Controller1 getController1()
           {
               return test1;
           }

           public Controller2 getController2()
           {
               return test2;
           }  

        }