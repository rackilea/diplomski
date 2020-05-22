@Column(name = "name")
public String getName() {
    return this.name;
}

public void setName(String s) {
    this.name = s;
}

@PrePersist
private void updateNoAccentName() {
    this.noAccentName = RemoveDiacritics(this.name);
}

@Column(name = "noaccent_name")
public String getNoAccentName() {
    return this.noAccentName;
}

private void setNoAccentName(String s) {
    this.noAccentName = s;
}