import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Errors {


   // private constructor 
    private Errors(List<SingleError> errors) {
        Errors.errors = errors;
    }

    private static List<SingleError> errors = new ArrayList<>();

    public static List<SingleError> getErrors() {
        return errors;
    }

   // New method to return Errors instance 
    public static Errors getErrorsInstance() {
        return new Errors(errors);
    }

    public static void addError(SingleError singleError) {
        errors.add(singleError);
    }

    }