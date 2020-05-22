@Override
@Transactional
public TerminalsModel getTerminalToken(String terminalToken) throws Exception {
    TerminalsModel terminal = null;
    Session session = entityManager.unwrap(Session.class);
    return (TerminalsModel) session.get(TerminalsModel.class, terminalToken);
}