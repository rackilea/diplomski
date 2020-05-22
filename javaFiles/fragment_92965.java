@Override
public String toString() {
    return new StringJoiner(", ", ClassName.class.getSimpleName() + "[", "]")
    .add("userId=" + userId)
    .add("timestamp=" + timestamp)
    .toString();
}