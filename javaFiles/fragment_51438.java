private boolean compareOrder(UserOrderDTO.OrderConfig givenDeviceConfig, List<UserOrderDTO.OrderConfig> masterConfigList) {

    return givenDeviceConfig.getIdentifier() != null
            && masterConfigList.stream().anyMatch(
                    p -> p.getIdentifier() != null
                         && p.getIdentifier().trim().equalsIgnoreCase(givenDeviceConfig.getIdentifier().trim()));

}