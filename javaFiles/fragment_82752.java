private void popup_dialog(final ArrayList<Integer> routeList) {
    int routeListSize = routeList.size();

    flag = false;

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            flag =true;                       
        }
    }, 10 * 1000 * 60);  // 10 minutes (60 sec * 1000 milliseconds)

    if (routeListSize > 0) {
        //AlertDialog.Build code
}