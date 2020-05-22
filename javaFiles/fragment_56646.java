RestrictedComboEnum[] combinations = RestrictedComboEnum.class
                .getEnumConstants();

        int random = (int) (Math.random() * combinations.length);

        RestrictedComboEnum selectedCombo = combinations[random];

        int random2 = (int) (Math.random() * selectedCombo.getClasses().length);

        label.setText("Your Race is: " + combinations[random]);
        label2.setText("Your Class is: "+ selectedCombo.getClasses()[random2]);