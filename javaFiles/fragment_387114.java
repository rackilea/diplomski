handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            newsItemAdapter.notifyDataSetChanged();
        }
}