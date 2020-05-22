@Mapper(config = AuditingEntityMapper.class)
public interface ManageableStatusMapper {

    @InheritConfiguration( name= "toDto" ) // really point to AuditingEntityMapper#toDto
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