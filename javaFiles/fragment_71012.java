public Func0 convertToFunc0(final Func3<type 1, type 2, type 3, Future> f, final type1 param1, final type2 param2, final type3 param3)
{
    return new Func0() {
        @Override
        public void call() {
            f.call(param1, param2, param3);
        }
    };
}