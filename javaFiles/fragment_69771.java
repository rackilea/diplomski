final Handler handler = new Handler() {
    public void handleMessage(android.os.Message msg) {
        // здесь все обращения к интерфейсу
        Toast.makeText(context, res, 3).show();
    }
};