public Map<LocationDTO, List<ReferralDetailsDTO>> getWaiting() {
    return referralDao.findAll()
            .stream()
            .map(ReferralDetailsDTO::new)
            .collect(Collectors.groupingBy(r -> locationDao.findById(r.getLocationId()));
}