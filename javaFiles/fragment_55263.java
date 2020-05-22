StringBuilder sb = new StringBuilder();
    Iterator<?> iter = this.iterator();
    if (iter.hasNext())
        sb.append(iter.next().toString());
    while (iter.hasNext()) {
        sb.append(", ");
        sb.append(iter.next().toString());
    }
    return sb.toString();