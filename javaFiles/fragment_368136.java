public void setName(@Nullable String name) {
    this.name = name; // should now have a warning
}

@NonNull
public String getName() {
    return name;
}