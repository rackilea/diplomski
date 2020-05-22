final LengthValidator validator =

     (LengthValidator)getApplication().createValidator(LengthValidator.VALIDATOR_ID);

   if (question.getMinLength() > 0)

     validator.setMinimum(question.getMinLength());

   if (question.getMaxLength() > 0)

     validator.setMaximum(question.getMaxLength());

   htmlInputText.addValidator(validator);