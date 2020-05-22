package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StringValidator {
    private List<String> stringList;
    private List<String> validationList;

    private final List<String> validatedList = new ArrayList<String>();

    @Autowired
    public StringValidator(final ArrayList<String> stringList,
                           final ArrayList<String> validationList) {
        this.stringList = stringList;
        this.validationList = validationList;
    }

    public void validate() {
        for (String currentString : stringList) {
            for (String currentValidation : validationList) {
                if (currentString.equalsIgnoreCase(currentValidation)) {
                    validatedList.add(currentString);
                }
            }
        }
    }

    public List<String> getValidatedList() {
        return validatedList;
    }
}