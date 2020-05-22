Set<String> ignored = new HashSet<String>();
ignored.add("value 1"); // store in lowercase
ignored.add("value 2"); // store in lowercase

public boolean ignore(String value) {
    return ignored.contains(value.toLowerCase());    
}