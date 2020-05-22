...
ActivityMonitor am = getInstrumentation().addMonitor(LoginActivity.class.getName(), null, false);

// Click the menu option
getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
getInstrumentation().invokeMenuActionSync(mActivity, R.id.logout, 0);

Activity a = getInstrumentation().waitForMonitorWithTimeout(am, 1000);
assertEquals(true, getInstrumentation().checkMonitorHit(am, 1));
a.finish();
...