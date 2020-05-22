public String getTags() {
    return tags;
}

public void setTags(String tags) {
    this.tags = tags;
}

public List<String> getTagsList() {
    return Arrays.asList(tags.split(","));
}

public void setTagsList(List<String> tags) {
    this.tags = String.join(",", tags);
}