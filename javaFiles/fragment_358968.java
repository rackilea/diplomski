public class Test {

    public static void main(String argsp[]) {
        PrintTypeImpl typeImpl = new PrintTypeImpl(new StringType(), new IntType(), new ObjectType());
        typeImpl.accept(new PrintVisitor());
    }

    static final class PrintVisitor implements TypeVisitor {
        public void visit(IntType x) {
            System.out.println("Int: ");
        }

        public void visit(StringType x) {
            System.out.println("String: ");
        }

        public void visit(ObjectType x) {
            System.out.println("Object: ");
        }
    }

    interface TypeVisitor {
        void visit(IntType i);

        void visit(StringType str);

        void visit(ObjectType obj);
    }

    interface PrintType {
        void accept(TypeVisitor visitor);
    }

    static class StringType implements PrintType {
        @Override
        public void accept(TypeVisitor visitor) {
            visitor.visit(this);
        }
    }

    static class ObjectType implements PrintType {
        @Override
        public void accept(TypeVisitor visitor) {
            visitor.visit(this);
        }
    }

    static class IntType implements PrintType {
        @Override
        public void accept(TypeVisitor visitor) {
            visitor.visit(this);
        }
    }

    static final class PrintTypeImpl implements PrintType {

        PrintType[] type;

        private PrintTypeImpl(PrintType... types) {
            type = types;
        }

        @Override
        public void accept(TypeVisitor visitor) {
            for (int i = 0; i < type.length; i++) {
                type[i].accept(visitor);
            }
        }
    }

}