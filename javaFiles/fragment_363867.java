@JsonGetter("parts")
public String getPartString() {
    String separator = ";";
    StringBuilder sb = new StringBuilder();

    Iterator<Part> iter = this.parts.iterator();
    while (iter.hasNext()) {
        Part p = iter.next();
        sb.append(p.getName());

        if (iter.hasNext())
            sb.append(separator);
    }

    return sb.toString();
}