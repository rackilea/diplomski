AtomicInteger cnt = new AtomicInteger(0);
StringBuilder buf = new StringBuilder("");
array.stream().forEach((item) -> {
    buf.append("Counter here: " + cnt.incrementAndGet() + "\n");
});
return buf.toString();