emailService.emptyMyInbox(fUsername, fPassword, new AsyncCallback() {
    public void onSuccess(Void result) {
      // do some UI stuff to show success
    }

    public void onFailure(Throwable caught) {
      // do some UI stuff to show failure
    }
};
// do something more