public class PersonSourceProvider extends AbstractSourceProvider{

/** This is the variable that is used as reference to the SourceProvider
 */
public static final String PERSON_ID = "com.voo.example.sourceprovider.currentPerson";
private Person currentPerson;

public PersonSourceProvider() {

}

@Override
public void dispose() {
    currentPerson = null;
}

**/**
 * Used to get the Status of the source from the framework
 */
@Override
public Map<String, Person> getCurrentState() {
    Map<String, Person> personMap = new HashMap<String, Person>();
    personMap.put(PERSON_ID, currentPerson);
    return personMap;
}**

@Override
public String[] getProvidedSourceNames() {
    return new String[]{PERSON_ID};
}

public void personChanged(Person p){
    if (this.currentPerson != null && this.currentPerson.equals(p)){
        return;
    }

    this.currentPerson = p;
    fireSourceChanged(ISources.ACTIVE_PART_ID, PERSON_ID, this.currentPerson);
}