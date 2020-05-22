Class ErrorVerbose { 
          private static boolean enabled = False;

          public static setEnable(boolean enable) 
                enabled = enable;
          }

          public static perror(String msg) {

               if (enabled) {
               /* Print */ 
               }

          }
   }


 class YourClass {

           public YourClass(....,boolean status) {

                ErrorVerbose.SetEnable(status)
                    .
                    . 
           }

   }