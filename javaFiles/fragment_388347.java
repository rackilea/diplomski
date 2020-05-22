public void setConfirmListenner(final OnClickListener listener) {
    ((Button) this.contentView.findViewById(R.id.confirmButton)).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            listener.onClick(MyDialogClass.this, BUTTON_POSITIVE);
        }
    });
}