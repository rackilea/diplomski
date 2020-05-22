// As stated.
class A {
    String name;
    double value;

    A(String name, double value) {
        this.name = name;
        this.value = value;
    }
}

// Powerset set.
class ASet {
    final ArrayList<String> names = new ArrayList<String>();
    double value = Double.MAX_VALUE;

    void adjoin(A a) {
        names.add(a.name);
        value = Math.min(value, a.value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (String name : names) {
            sb.append(name);
            sb.append(',');
        }
        sb.append(value);
        sb.append('}');
        return sb.toString();
    }
}

// Make power sets.
class PowerSetFactory {

    // Stack for intermediate results.
    final ArrayDeque<A> stack = new ArrayDeque<A>();

    // Source data.
    ArrayList<A> src;

    // Powerset under construction
    ArrayList<ASet> dst;

    // Recursive powerset calculator
    private void recur(int i) {
        if (i >= src.size()) {
            // Stack is complete. If more than 1 element,
            // add its contents to the result.
            if (stack.size() > 1) {
                ASet set = new ASet();
                for (A a : stack) set.adjoin(a);
                dst.add(set);
            }
        }
        else {
            // Otherwise recur both without and with this element
            // added to the stack.  Clean up the stack before return.
            recur(i + 1);
            stack.offerLast(src.get(i));
            recur(i + 1);
            stack.pollLast();
        }
    }

    // Get a powerset for the givens source data.
    ArrayList<ASet> getPowerSet(ArrayList<A> src) {
        this.src = src;
        this.dst = new ArrayList<ASet>();
        recur(0);
        return dst;
    }

    public void test() {
        ArrayList<A> data = new ArrayList<A>();
        data.add(new A("f", 2.1));
        data.add(new A("c", 1.1));
        data.add(new A("a", 0.3));
        for (ASet set : getPowerSet(data)) {
            System.out.print(set);
        }
        System.out.println();

        data.clear();
        data.add(new A("n", 0.5)); 
        data.add(new A("f",  1.9)); 
        data.add(new A("x",  0.1)); 
        data.add(new A("a",  1.9)); 
        data.add(new A("b",  1.1));
        for (ASet set : getPowerSet(data)) {
            System.out.print(set);
        }
        System.out.println();
    }
}