Set<ConstraintViolation<Contact>> validations = validator.validate(data);
if (validations.size() > 0) {
    Map<String, String> messages = new HashMap<>();
    for (ConstraintViolation v : validations) {
        messages.put(v.getPropertyPath().toString(), v.getMessage());
    }

    return Response.status(Response.Status.BAD_REQUEST).entity(messages).build();
}