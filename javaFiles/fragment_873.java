interface InfoMessAware {

         String getMessage();
    }

    interface BackPageAware {

         String getBackPage();
    }

class DefaultInfoMessAware {
         String getMessage() {
             return "message";
         }
}

class DefaultBackPageAware {
         String getBackPage() {
             return "backPage";
         }
}

    class MyBean implements InfoMessAware, BackPageAware {
         private InfoMessAware messAware = new DefaultInfoMessAware();
         private BackPageAware backPageAware = new DefaultBackPageAware();

         String getMessage() {
             return messAware.getMessage();
         }

         String getBackPage() {
             return backPageAware.getBackPage();
         }
    }