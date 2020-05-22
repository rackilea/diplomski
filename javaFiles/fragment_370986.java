@Mapper
public AssociateMapper{

    Associate mapAssociate(Associate associate);

    default List<Status> mapStatuses(List<Status> statuses) {
        return statuses.stream()
            .filter(Objects::nonNull)
            .filter(status -> Objects.equals("O", status.getStatusType()) || Objects.equals("A", status.getStatusType()) || Objects.equals("P", status.getStatusType()))
            .collect(Collectors.toList());
    }
}