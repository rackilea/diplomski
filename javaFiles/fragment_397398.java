public interface DeclExtractor {
    GenericDecleration[] extract(Class cl);
    final DeclExtractor forClasses = new DeclExtractor() {
        public GenericDecleration[] extract(Class cl) {
            // make an array of GenericDecleration from extracted classes
        }
    };
    final DeclExtractor forMethods = new DeclExtractor() {
        public GenericDecleration[] extract(Class cl) {
            // make an array of GenericDecleration from extracted methods
        }
    };
}