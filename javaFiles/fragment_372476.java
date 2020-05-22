public class Sentence {
private String verb;
private String object;
private String subject;
public Sentence(String verb, String object, String subject ){
    this.verb = verb;
    this.object = object;
    this.subject = subject;
}
public String getVerb(){ return verb; }
public String getObject(){ return object; }
public String getSubject(){ return subject; }
public String toString(){
    return verb + "(" + object + ", " + subject + ")";
}
}