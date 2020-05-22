UnaryOperator<TextFormatter.Change> filter = new UnaryOperator<TextFormatter.Change>() {

            @Override
            public TextFormatter.Change apply(TextFormatter.Change c) {

                if (c.isDeleted()) {
                    if (c.getControlNewText()
                         .endsWith(" ")) {
                        c.setRange(c.getRangeStart() - 1, c.getRangeEnd());
                    }
                }
                if (c.isAdded()) {
                }
                if (c.isReplaced()) {
                }
                return c;
            }
        };

        yourTextField.setTextFormatter(new TextFormatter<>(filter));