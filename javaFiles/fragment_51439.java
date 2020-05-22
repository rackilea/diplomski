private static boolean compareOrderLists(List<UserOrderDTO.OrderConfig> list1, List<UserOrderDTO.OrderConfig> list2) {

    return list1.stream().anyMatch(
            p -> p.getIdentifier() != null 
                 && list2.stream().anyMatch(
                        p2 -> p2.getIdentifier() != null 
                              && p2.getIdentifier().trim().equalsIgnoreCase(p.getIdentifier())));

}