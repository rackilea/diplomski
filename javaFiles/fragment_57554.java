public synchronized byte toByteArray()[] {
    return Arrays.copyOf(buf, count);
}

public synchronized int size() {
    return count;
}