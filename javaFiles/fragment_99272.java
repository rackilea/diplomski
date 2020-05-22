interface ICrushable {
    void crush();
}

utterlyDestroy(ICrushable parameter) {
    // Very long crushing process goes here
    parameter.crush()
}

utterlyDestroy(Dreams parameter) {
    utterlyDestroy(new ICrushable() { crush() {parameter.crush();});
}

utterlyDestroy(Garlic parameter) {
    utterlyDestroy(new ICrushable() { crush() {parameter.crush();});
}