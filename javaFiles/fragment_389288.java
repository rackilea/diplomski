@Override
    public boolean isValid(Country country, ConstraintValidatorContext context) {
        boolean result = (country==null||
                             country.getId() > 0 || 
                             (country.getName() != null && country.getName() != ""));
        return result;
    }