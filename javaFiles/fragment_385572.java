@Override
public int compareTo(Object obj) {
    if(!(obj instanceof CharacterFrequency)) {
        throw new IllegalArgumentException("Does not equal test class");        
    }
    CharacterFrequency t = (CharacterFrequency) obj;
    return Character.compare(character, t.character);
}