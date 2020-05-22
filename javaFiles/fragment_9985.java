public interface SubMasterMapper {
    SubMasterDTO toDto(SubMaster entity);
}

@Mapper(uses = { SubMasterMapper.class })
public interface MasterMapper {
    MasterDTO toDto(Master entity);
}