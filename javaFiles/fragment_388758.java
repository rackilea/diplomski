while (!resourceMap.isEmpty()) {
    Iterator<Resource> iterator = resourceMap.values().iterator();
    while (iterator.hasNext()) {
       Resource resource = iterator.next();
       iterator.remove();
       resource.destroy();
    }
}