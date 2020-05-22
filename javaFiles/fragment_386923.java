public class OwnerFinder {
    public static void main(String[] args) {
        try {
            ClassPath classPath = ClassPath.from(OwnerFinder.class.getClassLoader());
            classPath.getTopLevelClassesRecursive("com.somepackage")
                    .stream()
                    .filter(c -> c.getSimpleName().equals("package-info"))
                    .map(c -> c.load().getPackage().getAnnotation(PackageOwner.class))
                    .forEach(a -> System.out.println(a.owner()));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}