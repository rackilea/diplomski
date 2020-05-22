class RawConsumer {

    @Autowired
    private FindByIndexNameSessionRepository sessionRepository;

    void consume() {
        Session session = (Session) this.sessionRepository.createSession();
        session.setAttribute("test", UUID.randomUUID().toString());
        this.sessionRepository.save(session);
    }

}