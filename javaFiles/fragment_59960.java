private void permissionCheck(){
    if (isSendSmsAllowed()) {
          sendSms();
          return;
      }

    requestSmsSendPermission();}