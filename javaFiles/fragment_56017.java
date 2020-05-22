try {
        Object model = JAXB.unmarshal(new StringReader(xmlString), classe);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(model);

        for(ConstraintViolation violation : violations){
            responseError.append("Errore al percorso '" + violation.getPropertyPath() +"': ");
            responseError.append(" il valore trovato e' '" + violation.getInvalidValue() + "' ");
            responseError.append(", mentre il valore atteso deve rispettare il seguente criterio: '" + violation.getMessage() + "'. \n\n");
        }
    } catch (Exception e) {
        responseError.append("Eccezione nel parsing dell'oggetto: " + e.toString() + ". Probabilmente il file XML di input non e' ben formato. Controllare i tag di apertura e di chiusura.  \n\n");
    }