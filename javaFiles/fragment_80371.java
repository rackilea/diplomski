@AfterReturning(pointcut = "servicePointCut()", returning = "entity")
public void afterReturningAdvice(JoinPoint joinPoint, Object entity) throws IllegalAccessException 

{

    //Iterate through fields of entity
    for (Field field : entity.getClass().getDeclaredFields()) {

        //Check type of field (equals to BaseDto.class)
        if (field.getType().equals(BaseDto.class)) {

            //Set accessibility of field to true
            field.setAccessible(true);

            //Set new BaseDto to entityobject
            BaseDto baseDto = new BaseDto();
            field.set(entity, baseDto);
        }

    }

 //Rest of afterReturningAdvice method ...
}