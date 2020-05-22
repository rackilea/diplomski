public void performLambdasDemo() {
            // Declare variables which are going to be used in the lambda closure
            final Pair methodPairIntegerValue = new Pair(RandomUtils.nextInt(), RandomUtils.nextInt());
            final Integer methodIntegerValue = RandomUtils.nextInt();
            // Declare lambda
            final Supplier methodSupplierLambda = () -> {
                return methodPairIntegerValue.fst + 9000 + methodIntegerValue.intValue();
            };
            // Declare anonymous class
            final Supplier methodSupplierInnerClass = new Supplier() {
                @Override
                public Integer get() {
                    return methodPairIntegerValue.fst + 9001 + methodIntegerValue.intValue();
                }
            };
            System.out.println(methodSupplierLambda.get());
            System.out.println(methodSupplierInnerClass.get());
        }