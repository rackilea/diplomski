@Mapper(config = AuditingEntityMapper.class, mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG )
public interface ManageableStatusMapper {

    // no explicit @InheritConfiguration required, because of AUTO_INHERIT_ALL_FROM_CONFIG
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