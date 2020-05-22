this.mbtnConnect.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        new Thread(new RxRun(rfcSocket)).start();
    }
});