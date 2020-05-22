int seen = 0

Iterator<K> keys = map.keySet().iterator();
while (keys.hasNext()) {
    if (m==0)
      break;

    keys.next();
    prob = m / (double)(n-seen)  //renormalise the prob so that the total available is 1 across all remaining instances
    if (random.nextDouble() < prob) {
        keys.remove();
        m--;
    }
    seen++;
}