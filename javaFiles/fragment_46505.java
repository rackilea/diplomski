public String toString() {
    StringBuilder result = new StringBuilder();
    for(int i = 0; i<states.length; i++) {
        result.append(states[i]);
        result.append("\n");
        }
    return result.toString();
}