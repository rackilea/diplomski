interface IoBiFunction<T, U, R> {
  R apply(T t, U u) throws IOException;
}
class LambdaFileVisitor<T> extends SimpleFileVisitor<T> {
    IoBiFunction<T, BasicFileAttributes, FileVisitResult> preVisitDir=super::preVisitDirectory;
    IoBiFunction<T, BasicFileAttributes, FileVisitResult> visitFile=super::visitFile;
    IoBiFunction<T, IOException, FileVisitResult> visitFailed=super::visitFileFailed;
    IoBiFunction<T, IOException, FileVisitResult> postVisitDir=super::postVisitDirectory;

    public LambdaFileVisitor<T> onVisitFile(IoBiFunction<T, BasicFileAttributes, FileVisitResult> f) {
        this.visitFile = Objects.requireNonNull(f);
        return this;
    }
    public LambdaFileVisitor<T> onVisitFailed(IoBiFunction<T, IOException, FileVisitResult> f) {
        this.visitFailed = Objects.requireNonNull(f);
        return this;
    }
    public LambdaFileVisitor<T> onPreVisitDir(IoBiFunction<T, BasicFileAttributes, FileVisitResult> f) {
        this.preVisitDir = Objects.requireNonNull(f);
        return this;
    }
    public LambdaFileVisitor<T> onPostVisitDir(IoBiFunction<T, IOException, FileVisitResult> f) {
        this.postVisitDir = Objects.requireNonNull(f);
        return this;
    }
    @Override
    public FileVisitResult visitFile(T file, BasicFileAttributes attrs) throws IOException {
        return visitFile.apply(file, attrs);
    }
    @Override
    public FileVisitResult visitFileFailed(T file, IOException exc) throws IOException {
        return visitFailed.apply(file, exc);
    }
    @Override
    public FileVisitResult preVisitDirectory(T dir, BasicFileAttributes attrs) throws IOException {
        return preVisitDir.apply(dir, attrs);
    }
    @Override
    public FileVisitResult postVisitDirectory(T dir, IOException exc) throws IOException {
        return postVisitDir.apply(dir, exc);
    }
}