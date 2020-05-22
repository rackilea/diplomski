private String[] words;

@XmlElement(name="Words")
public void setWords(String[] words) {
    /* Converting String to Array */
    this.words = words[0].split(", ");
}