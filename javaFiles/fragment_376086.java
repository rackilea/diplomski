package test;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Component
public class StringService implements Stringable {

    private List<String> stringList;

    @Inject
    public StringService(final ArrayList<String> stringList) {
        this.stringList = stringList;
        createList();
    }

    //Simplified
    private void createList() {
        stringList.add("FILE1.txt");
        stringList.add("FILE1.dat");
        stringList.add("FILE1.pdf");
        stringList.add("FILE1.rdf");
    }

    @Override
    public List<String> getStringList() {
        return stringList;
    }
}

package test;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationService implements Validateable {

    private List<String> validationList;

    @Inject
    public ValidationService(final ArrayList<String> validationList) {
        this.validationList = validationList;
        createList();
    }

    //Simplified...
    private void createList() {
        validationList.add("FILE1.txt");
        validationList.add("FILE2.txt");
        validationList.add("FILE3.txt");
        validationList.add("FILE4.txt");
    }

    @Override
    public List<String> getValidationList() {
        return validationList;
    }
}