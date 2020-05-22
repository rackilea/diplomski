@PostMapping
    public WhoIs whoIs(@RequestBody Request request) {
        System.out.println(request);
        DomainInfo domainInfo = domainRepository.findDomainInfo(request.getDomain());
        ContactInfo contactInfo = contactsRepository.findContactInfo(request.getDomain());
        List<HostInfo> hostInfo = hostRepository.findHostInfo(request.getDomain());
        List<StatusInfo> statusInfo = statusRepository.findStatusInfo(request.getDomain());

        return new WhoIs(domainInfo, contactInfo, hostInfo, statusInfo);
    }