public class Ontology {
private List<Sentence> sentences = new ArrayList<>();
/*
 * The following maps store the relation of a string occurring
 * as a subject or object, respectively, to the list of Sentence
 * ordinals where they occur.
 */
private Map<String,List<Integer>> subject2index = new HashMap<>();
private Map<String,List<Integer>> object2index = new HashMap<>();
/*
 * This set contains strings that occur as both,
 * subject and object. This is useful for determining strings
 * acting as an in-between connecting two relations. 
 */
private Set<String> joints = new HashSet<>();
public void addSentence( Sentence s ){
    // add Sentence to the list of all Sentences
    sentences.add( s );
    // add the Subject of the Sentence to the map mapping strings
    // occurring as a subject to the ordinal of this Sentence
    List<Integer> subind = subject2index.get( s.getSubject() );
    if( subind == null ){
       subind = new ArrayList<>();
        subject2index.put( s.getSubject(), subind );
    }
    subind.add( sentences.size() - 1 );
    // add the Object of the Sentence to the map mapping strings
    // occurring as an object to the ordinal of this Sentence
    List<Integer> objind = object2index.get( s.getObject() );
    if( objind == null ){
        objind = new ArrayList<>();
        object2index.put( s.getObject(), objind );
    }
    objind.add( sentences.size() - 1 );
    // determine whether we've found a "joining" string
    if( subject2index.containsKey( s.getObject() ) ){
        joints.add( s.getObject() );
    }
    if( object2index.containsKey( s.getSubject() ) ){
        joints.add( s.getSubject() );
    }
}
public Collection<String> getJoints(){
    return joints;
}
public List<Integer> getSubjectIndices( String subject ){
    return subject2index.get( subject );
}
public List<Integer> getObjectIndices( String object ){
    return object2index.get( object );
}
public Sentence getSentence( int index ){
    return sentences.get( index );
}
}