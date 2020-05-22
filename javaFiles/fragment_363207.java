private final StringProperty projectName;

@Column(name = "PROJECTNAME")
public final String getProjectName() {
    return projectName.get();
}

public final void setProjectName(String projectName) {
    this.projectName.set(projectName);
}

public StringProperty projectNameProperty() {
    return projectName;
}