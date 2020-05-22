if(android.os.Build.VERSION.SDK_INT >= 21)
    finishAndRemoveTask();
else
    finish();

android.os.Process.killProcess(Process.myPid()); // it can be system.exit(0) too