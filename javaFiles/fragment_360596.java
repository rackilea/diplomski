final DateTimePicker fromInput = new DateTimePicker("from",
                model(criteriaModel, on(RechercheServiceFunctionCriteria.class).getFromDate()),
                DateTimePicker.START_OF_DAY) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isRequired() {
                return Strings.isBlank(tidField.getConvertedInput());
            }

        };
        form.add(fromInput);
        form.add(new FormComponentFeedbackPanel("fromFeedbackPanel", fromInput));

        final DateTimePicker toInput = new DateTimePicker("to",
                model(criteriaModel, on(RechercheServiceFunctionCriteria.class).getToDate()),
                DateTimePicker.END_OF_DAY) {

            /**
                     *
                     */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isRequired() {
                return Strings.isBlank(tidField.getConvertedInput());
            }
        };
        form.add(toInput);