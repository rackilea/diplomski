import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

class Errors {  
 private List<SingleError> errors = new ArrayList<>();
 public List<SingleError> getErrors() {
            return errors;
 }

 public void addError(SingleError singleError) {
            errors.add(singleError);
 }