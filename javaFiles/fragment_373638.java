// Message class:
public String toString() {
    return getText() + "-->" + getMessageDetails().toString();
}

// MessageDetails class
public String toString() {
    return "{" + getId() + ", " + getStatus() + "}";
}