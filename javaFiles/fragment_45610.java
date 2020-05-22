public <C, D> Either<C, D> flatMap(Function<B, Either<C, D>> f) {
    if (this.isRight()) {
        return f.apply(this.right);
    } else {
        // Error: can't convert A to C
        return Either.left(this.left);
    }
}