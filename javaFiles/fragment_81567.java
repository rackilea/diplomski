public String getElementInfo() {
    return element.info;
}

Collection<String> result = list.stream()
    .map(container::getElementInfo)
    .collect(Collectors.toList());