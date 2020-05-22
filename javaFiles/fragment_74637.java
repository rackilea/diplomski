@Override
public void initialize(FieldMatch constraintAnnotation)
{
    firstFieldName = constraintAnnotation.first();
    secondFieldName = constraintAnnotation.second();
    thirdFieldName = constraintAnnotation.third();
    match = constraintAnnotation.match();

    //set a message variable on initialization    
    if("true".equals(match)){
        message = constraintAnnotation.message();
    }
    else{
        message = "{password.error.threeQuestionsSameAnswer}";}
}

@Override
public boolean isValid(final Object value, final ConstraintValidatorContext context)
{
    Object firstObj = null;
    Object secondObj = null;
    Object thirdObj = null;

    //disable existing violation message
    context.disableDefaultConstraintViolation();
    //build new violation message and add it
    context.buildConstraintViolationWithTemplate(message).addConstraintViolation();

etc.........
}