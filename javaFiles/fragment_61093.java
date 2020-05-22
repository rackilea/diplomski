myService.performSomeAction(...) {

     @Override
     public void onSuccess(String result) {

          ClientTimers.renewSessionTimer();

          // remaining onSuccess handling
     }

     @Override
     public void onFailure(Throwable caught) {

          if (failedBecauseOfSessionTimeout()) {

              // redirect to login

          } else {

              ClientTimers.renewSessionTimer();

              // remaining onFailure handling...
          }
     }
 }