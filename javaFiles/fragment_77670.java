// Inside the constructor

    LabelField label1 = new LabelField("Hello World Demo" , LabelField.ELLIPSIS | LabelField.USE_ALL_WIDTH);

    EditField firstNameEditField = new EditField(EditField.NO_NEWLINE | EditField.NON_SPELLCHECKABLE | EditField.NO_COMPLEX_INPUT);

    EditField lastNameEditField = new EditField(EditField.NO_NEWLINE | EditField.NON_SPELLCHECKABLE | EditField.NO_COMPLEX_INPUT);

    ButtonField submitButton = new ButtonField("Submit")
            {
                protected boolean navigationClick(int status, int time) 
                {
                    onSubmit();

                    return true;
                }
            };

        this.add(label1);
        this.add(firstNameEditField);
        this.add(lastNameEditField);
        this.add(submitButton);