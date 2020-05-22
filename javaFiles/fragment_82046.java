private void mpilih() {
        if (!TextUtils.isEmpty(edit.getText())) {
            hasil.setText(getString(R.string.sun));
        } else {
            edit.setError("Please enter your selection");
        }
    }