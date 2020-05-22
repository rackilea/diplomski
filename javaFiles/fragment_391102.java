View.OnClickListener yourListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (v == button1) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Paracettamol")
                        .setMessage(
                                "This medicine is generally used to cure Fever")
                        .setNeutralButton("OK", null).show();
            } else if (v == button2) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("sertraline")
                        .setMessage(
                                "This medicine is generally used to cure Head aches")
                        .setNeutralButton("OK", null).show();
            }

        }
    };