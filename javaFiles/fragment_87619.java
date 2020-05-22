@Autowired
SessionFactory sessionFactory;

@Transactional(propagation = Propagation.REQUIRED)
public Boolean EnumObjType(EnumobjType obj) {

    boolean flag=false;
    int i  =(integer)sessionFactory.getCurrentSession().save(obj).intValue();

    if (i > 0) {
        flag = true;
    }
    return flag;


}