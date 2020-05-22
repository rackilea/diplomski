public static final int RC_CDIALOG = 111;

button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               showDialogFragment(FragmentA.this, new CDialog(), RC_CDIALOG);
            }
        });