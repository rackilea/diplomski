public void processField(Element fieldElement, String fieldName){
    BeanPropertyBindingResult binding = new BeanPropertyBindingResult(
            this.realObject, this.root);
    PropertyDescriptor rootProp = this.beanDescriptor
            .getConstraintsForProperty(fieldName);
    List<PropertyDescriptor> finalProp = new LinkedList<PropertyDescriptor>();
    if (rootProp.isCascaded())// if it's nested, scan all properties for
                            // annotation
        finalProp.addAll(this.validator.getConstraintsForClass(
                rootProp.getElementClass()).getConstrainedProperties());
    else
        finalProp.add(rootProp);
    for (PropertyDescriptor prop : finalProp)
        for (final ConstraintDescriptor<?> desc : prop
                .getConstraintDescriptors()) {
            Annotation constraint = desc.getAnnotation();
            String className = this.beanDescriptor.getElementClass()
                    .getSimpleName();
            className = Character.toLowerCase(className.charAt(0))
                    + className.substring(1);
            String field = className + "." + prop.getPropertyName();
            String errorCode = constraint.annotationType().getSimpleName();
            Object[] errorArgs = this.validator.getArgumentsForConstraint(
                    this.root, field, desc);
            String message = (String) desc.getAttributes().get(ANNOTATION_MESSAGE);
            if (INTERNAL.matcher(message).find())
                message = this.validatorFactory.getMessageInterpolator().interpolate(
                        message, new Context() {

                            public Object getValidatedValue() {
                                return null;
                            }

                            public ConstraintDescriptor<?> getConstraintDescriptor() {
                                return desc;
                            }
                        });
            String[] errorCodes = binding.resolveMessageCodes(errorCode,
                    field);
            binding.addError(new FieldError(binding.getObjectName(), prop
                    .getPropertyName(), null, false, errorCodes, errorArgs,
                    message));
        }

    List<ObjectError> errors = binding.getAllErrors();
    StringBuilder customValidation = new StringBuilder();
    for (ObjectError e : errors) {
        String s = this.requestContext.getMessage(e, true);
        customValidation.append(s);
        if (!s.endsWith("."))
            customValidation.append(". ");

    }
    String onInvalid = String.format("this.setCustomValidity('%s')",
            customValidation.toString());
    fieldElement.setAttribute(ONINVALID_ATTR, onInvalid);
    fieldElement.setAttribute(ONCHANGE_ATTR, "this.setCustomValidity('')");
}