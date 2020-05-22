Participants tempParti = ((Participants) session.createQuery("FROM Participants WHERE name = '" + p.getName() + "' AND function = '" + p.getFunction() + "' AND contact = '" + p.getContact() + "'").uniqueResult());
if (tempParti != null) {
    p = tempParti;
} else {
    session.save(p);
}