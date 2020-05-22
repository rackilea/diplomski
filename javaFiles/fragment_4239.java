public ? doInBackground(?... ?s) {
    while (shouldCopy) {
        while (needUserVerfication)
            if (!verifying) 
                publishProgress(NEED_USER_VERIFICATION);
        else
            // ...
    }
}

public void onProgressUpdate(Integer... ints) {
    switch (ints[0]) {
    case NEED_USER_VERIFICATION:
        AlertDialog.Builder adb = new AlertDialog.Builder(mContext);
        adb.setTitle("Lisen!");
        adb.setMessage("I need your input");
        adb.setPostiveClickListener("Accept", this)
        adb.setNegativeClickListener("Cancel", this)
        adb.show();
    case PUBLISH_PROGRESS:
        // Update progress
    }
}

public void onClick(DialogInterface dialog, int which) {
    if (DialogInterface.POSITIVE == which) {
        needUserVerification = true
    } else {
        needUserVerification = false
    }
    verifying = false
}