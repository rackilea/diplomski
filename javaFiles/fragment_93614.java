for (Object object : bindingResult.getAllErrors()) {
    if(object instanceof FieldError) {
        FieldError fieldError = (FieldError) object;

        System.out.println(fieldError.getCode());
    }

    if(object instanceof ObjectError) {
        ObjectError objectError = (ObjectError) object;

        System.out.println(objectError.getCode());
    }
}