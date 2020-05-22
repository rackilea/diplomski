GenerationConfig config = new DefaultGenerationConfig() {
...
@Override
public boolean isParcelable() {
    return true;
}
...
}