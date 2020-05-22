Pattern pattern = Pattern.compile(prop);
Iterator<Entry<...>> it = o.entrySet().iterator();
while (it.hasNext()) {
    Entry<...> entry = it.next();
    if (pattern.matcher(entry.getKey()).matches()) {
        i.remove();
    }
}