private static final void loops(int i, StringBuffer buffer, int level, int k, int size) {
        if  (level>=k){
            out.add(buffer.toString());
        } else {
            for (int j = i; j < size; j++) {
                StringBuffer buf = new StringBuffer(buffer);
                buf.append(l.get(j));
                loops(j+1, buf, level+1, k, size);
            }
        }
}

... main() ...
    int size = l.size();
    loops(0, new StringBuffer(50), 0, 4, size);
... main() ...