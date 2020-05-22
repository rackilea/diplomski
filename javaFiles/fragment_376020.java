@Transactional(propagation = Propagation.REQUIRES_NEW)
public abstract class GenericAdminServiceImpl<ENTITY extends AbstractEntity, DTO extends AbstractDto>
    implements GenericAdminService<ENTITY, DTO> {

    // ...

}