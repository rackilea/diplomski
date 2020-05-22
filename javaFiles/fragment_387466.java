@PostMapping
public DomainInfo whoIs(@RequestBody Request request) {
  // ...
  DomainInfo domainInfo = domainRepository.findDomainInfo(request.getDomain());
  // ...
  return domainInfo;
}