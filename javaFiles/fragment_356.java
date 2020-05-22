protected List<String> extractErrorMessages(BindingResult result) {
        List<String> errorMessages = new ArrayList<>();
        for (Object object : result.getAllErrors()) {
            if (object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;
                errorMessages.add(fieldError.getCode());
            }
        }
        return errorMessages;
    }