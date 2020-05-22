dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        for (Communicator communicator : communicators) { 
            communicator.onConfirmClick();
        }
    }
});