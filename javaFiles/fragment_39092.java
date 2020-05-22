@XmlElement(name="element") 
void setElement(String value) {
    // parse value
    StringTokenizer st = new StringTokenizer(value, "()");
    this.one = st.nextToken().trim();
    this.two = st.nextToken().trim();
}