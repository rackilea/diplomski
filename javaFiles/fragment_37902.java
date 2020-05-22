class CheckNumberValidator implements ConstraintValidator<CheckNumberValid, String>{

         @Override
         public boolean isValid(String value, ConstraintValidatorContext context) {
             if(value.length() > 1 && value.length() < 3) {
                 try {
                     Integer integer = Integer.valueOf(value);
                     if(something_wrong) {
                         context.disableDefaultConstraintViolation();
                         context.buildConstraintViolationWithTemplate("{tooLargeNum}").addConstraintViolation();
                         return false;
                     }
                 } catch (Exception ex) {
                     context.disableDefaultConstraintViolation();
                     context.buildConstraintViolationWithTemplate("{numParseError}").addConstraintViolation();
                     return false;
                 }

             }
             return true;
         }
     }