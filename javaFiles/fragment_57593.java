private void showDialogs(List<AlertList> list) {
    if (list == null || list.size() == 0) return;

    AlertList data = list.get(0);
    list.remove(0);

    AlertDialog dialog = new AlertDialog.Builder(context)
            .setMessage(data.getStrComment())
            .setCancelable(data.isCancelable())
            .create();
    dialog.setCanceledOnTouchOutside(data.isCancelable());

    CountDownTimer timer = new CountDownTimer(data.getTime() * 1000, data.getTime() * 1000) {

        @Override
        public void onTick(long millisUntilFinished) { }

        @Override
        public void onFinish() {
            dialog.dismiss(); 
        }
    };

    dialog.setOnDismissListener(dialog1 -> {
        timer.cancel();
        showDialogs(list);
    });

    dialog.show();
    timer.start();
}