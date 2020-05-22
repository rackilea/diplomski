public String getFamilyMembers() {
    StringBuilder sb = new StringBuilder();
    for (Person person : this.family) {
        sb.append(person.toString();
    }
    return sb.toString();
}