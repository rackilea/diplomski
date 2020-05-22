@Mapper(config = AuditingEntityMapper.class)
public interface ManageableStatusMapper {

    @InheritConfiguration // use this one to inherit stuf from the config
    @Mapping(target = "project", ignore = true)
    @Mapping(target = "organization", ignore = true)
    ManageableStatus toEntity(ManageableStatusDTO manageableStatusDTO);

    default ManageableStatus fromId(String id) {
        if (id == null) {
            return null;
        }
        ManageableStatus manageableStatus = new ManageableStatus();
        manageableStatus.setId(id);
        return manageableStatus;
    }
}