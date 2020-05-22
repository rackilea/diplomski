public class UserServiceImpl implements UserDetailsService, UserService {

private UserDAO dao;


@Override
@Transactional(rollbackFor=ApplicationException.class)
public void save(User c) throws ApplicationException {
    try {
        dao.save(c);
    } catch(DataIntegrityViolationException cve) {
        throw new ApplicationException("email already registered");
    }
}