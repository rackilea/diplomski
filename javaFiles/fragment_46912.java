final StringBuilder command = new StringBuilder();

    command
        .append("add user ")
        .append(textUser.getText());

    final String gender = textGender.getText();

    if(gender != null && !gender.equals("")) {
        command
            .append(" Gender ")
            .append(gender);
    }

    textOut.setText(command.toString());