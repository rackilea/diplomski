reader.setLineMapper(new DefaultLineMapper<String>() {
        {
            //Setea los valores en la clase indicada
            setFieldSetMapper(new FieldSetMapper<String>() {

                @Override
                public String mapFieldSet(FieldSet fieldSet) throws BindException {
                    String[] values = fieldSet.getValues();
                    return String.join(";", values);
                }

            });

            setLineTokenizer(new DelimitedLineTokenizer(";"));

        }
    });