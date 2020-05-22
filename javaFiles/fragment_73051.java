public boolean isValid(ChangePasswordFormModel cpfm, Class<?> ... groups) {
   for(Class<?> c : groups) {
      if(validator.validate(cpfm, c).size() > 0) {
         return false
      }
   }
   return true;
}