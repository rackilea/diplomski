public void onActivityResult(int reqCode, int resultCode, Intent data) {
    super.onActivityResult(reqCode, resultCode, data);

    switch (reqCode) {
      case (CALENDAR_DONE) :
        if (resultCode == Activity.RESULT_OK) {
          //Do stuff here
        }       
      break;
    }
  }