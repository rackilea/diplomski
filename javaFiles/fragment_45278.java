@Transactional("hibernate")
@Override
public void updateMessage(Message transientObject) throws MyDaoException {
  Session session = getCurrentSession();
  session.save(message);
}