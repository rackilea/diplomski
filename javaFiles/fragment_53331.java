class ParameterizedConsumer<S extends Session> {

    @Autowired
    private FindByIndexNameSessionRepository<S> sessionRepository;

    void consume() {
        S session = this.sessionRepository.createSession();
        session.setAttribute("test", UUID.randomUUID().toString());
        this.sessionRepository.save(session);
    }

}