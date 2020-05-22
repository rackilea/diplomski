public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    TreeMap<Integer, Integer> ts = new TreeMap<>(); // stores and polls checkout times
    sort(arrive, depart);
    int in = 0; // current number of guests
    int out = Integer.MAX_VALUE; // next checkout time
    for (int i = 0; i < arrive.size(); i++) {
        in++; // check in

        // new checkout time is earlier than current
        // no need to put it into ts just to take it out
        if (depart.get(i) < out) {
            // add current checkout to ts for future use
            ts.compute(out, (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
            out = depart.get(i);
        } else {
            ts.compute(depart.get(i), (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }

        if (out <= arrive.get(i)) { // check out
            in--;
            // poll next checkout time
            out = ts.firstKey();
            if (ts.get(out) == 1) {
                ts.remove(out);
            } else {
                ts.compute(out, (key, value) -> {
                    return value - 1;
                });
            }                
        }
        if (in > K) { // guests exceed room
            return false;
        }
    }

    return true;
}