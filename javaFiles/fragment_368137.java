public void setName(@NonNull String name) {
    // setName(null) would cause a warning
    // Also add an exception if the annotation is ignored.
    this.name = Objects.requireNonNull(name);
}

/* or */

public void setName(@Nullable String name) {
    if (name == null) return; // Guard against setting null
    this.name = name;
}