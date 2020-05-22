@Autowired
private ListableBeanFactory beanFactory;

@EventListener({ContextRefreshedEvent.class})
void contextRefreshedEvent() {
    auditLogDao = beanFactory.getBean(AuditLogDao.class);
}