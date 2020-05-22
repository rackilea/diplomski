obj = new DLSyntaxObjectRenderer();
ShortFormProvider shortFormProvider = new ShortFormProvider() {
                @Override
                public String getShortForm(OWLEntity owlEntity) {
                    return owlEntity.getIRI().getIRIString();
                }
            };
obj.setShortFormProvider(shortFormProvider);