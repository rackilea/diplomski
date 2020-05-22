public enum FunctionInvoker {
    func1 {
        public Object invoke(MyFunctions o, Object ... arg) {
             o.func1(arg[0]);
        }
    },
    func2 {
        public Object invoke(MyFunctions o, Object ... arg) {
             o.func2(arg[0], arg[1]);
        }
    },
}