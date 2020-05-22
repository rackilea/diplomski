private List<ServiceTag> serviceTags = new ArrayList<>();
public List<ServiceTag> getServiceTags() {
  return serviceTags;
}
public void addServiceTag(ServiceTag st) {
  serviceTags.add(st);
}
public void addServiceTags(Collection<ServiceTag> sts) {
  serviceTags.addAll(sts);
}