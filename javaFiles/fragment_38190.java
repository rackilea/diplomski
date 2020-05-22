private final static String getStrOrNull(final String str) throws Exception {
    // first step prepare table for different states:
    // 0 - input value is null
    // 1 - input value is some not null string
    // in single thread application you can move this array out of the function as static variable to avoid memory allocation
    final Callable<String>[] func = new Callable[2];

    func[0] = new Callable<String>() {
        @Override
        public String call() {
            return null;
        }
    };

    func[1] = new Callable<String>() {
        @Override
        public String call() {
            return str.toLowerCase(); // any other string modification
        }
    };

    // now we need to convert our input variable into "state" (0 or 1)
    // to do this we're inserting string into set
    // if string is not null - it will be in map, final size will be 1
    // if string is null - we will remove it via remove(null), final size will be 0
    final Set<String> set = new HashSet<String>();
    set.add(str);
    set.remove(null);

    return func[set.size()].call();
}