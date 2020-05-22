Public Thread persistentRfbThread(){

    detachThread();
    RFBThread persistentRfbThread = this.rfbThread;
    this.rfbThread = null;
    return persistentRfbThread;
    }

and this-


       Public SavedState mystate(){
      if (_listeningDialog.isShowing() && _currentRecognizer != null)
    {
        // If a recognition is in progress, save it, because the activity
        // is about to be destroyed and recreated
        SavedState savedState = new SavedState();
        savedState.Recognizer = _currentRecognizer;
        savedState.DialogText = _listeningDialog.getText();
        savedState.DialogLevel = _listeningDialog.getLevel();
        savedState.DialogRecording = _listeningDialog.isRecording();
        savedState.Handler = _handler;

        _currentRecognizer = null; // Prevent onDestroy() from canceling
        return savedState;
    }
    return null;
    }