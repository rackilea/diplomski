@Transactional
public void saveAccountComment() throws SystemException {
 Date lastEdited = new Date();
    Officer lastEditor = utils.getOfficer();
    accountForm.setLastEditDate(lastEdited);
    accountForm.setLastEditor(lastEditor.getEmpIdAndFullName());

    Query q = em.createNamedQuery("findAccountByAccountKey").setParameter("accountKey", acctInfo.getAccount().getAccountKey());
    Account account = (Account) q.getSingleResult();
    account.setCommentLastEdited(lastEdited);
    account.setCommentLastEditorEmployeeId(lastEditor.getEmployeeId());
    account.setComment(accountForm.getCommentText());
    em.persist(account);
}