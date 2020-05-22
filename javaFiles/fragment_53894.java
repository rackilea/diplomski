static void addObject(List<Object> objs) { objs.add("a"); }

static void addObjectToRaw(List objs) { objs.add("a"); }

public static void main(String[] args) {
   final List<Boolean> bools = new ArrayList<>();
   addObject(bools);       // compiler detects error
   addObjectToRaw(bools);  // compiler is silent
}