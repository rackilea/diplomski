public interface Validator {
    public boolean validate(ThingToValidate thingToValidate);
}

public final class TrueValidator implements Validator {
    //Note that the method is not static
    public boolean validate(ThingToValidate thingToValidate) {
        return true;
    }
}

public interface ValidatorFactory {
    public Validator createFromType(String type);
}

//Concrete validation factory using reflection
public final class ReflectiveValidatorFactory implements ValidatorFactory {
    public Validator createFromType(String type) {
        /*Use reflection to resolve the class based on the interface
        and naming conventions and/or annotations. 
        You may also cache the validator to avoid re-resolving it.*/
    }
}

//Concrete validation factory where validator types are hard-coded.
public final class HardcodedValidatorFactory implements ValidatorFactory {
    public Validator createFromType(String type) {
        switch (type) {
            case 'True': return new TrueValidator();
            //...
        }
    }
}

//Example of a client class that would use the ValidatorFactory
public final class ValidationService {
    private final ValidatorFactory validatorFactory;

    public ValidationService(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    public boolean validate(String validatorType, ThingToValidate thingToValidate) {
        Validator validator = validatorFactory.createFromType(validatorType);

        return validator.validate(thingToValidate);
    }
}