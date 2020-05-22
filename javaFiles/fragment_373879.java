send.setOnClickListener(v -> {
        content = message.getText().toString(); // <!-- always null
        if (searchSpinner.getSelectedItems().size() == 0 || content.equals("")) {
            Toast.makeText(getApplicationContext(),
                    content + " > " +
                            categoryList.toString().substring(1, categoryList.toString().length()-1),
                    Toast.LENGTH_LONG).show();
        } else {
            if (imageList.size() != 0) {
                doMultipartRequest();
            } else {
                doSendRequest();
            }
        }
    });