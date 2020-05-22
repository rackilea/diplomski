//Remove relationships
List<Video> videoList;
for (Video v : videoList) {
    for(Tag t : video.getTags()){
        t.getVideos.remove(v);
        v.getTags.remove(t);
    }
}

//Update owner entities
for (Video v : videoList) {
    Session sess = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = sess.beginTransaction();
    sess.update(v);
    tx.commit();
    sess.close();
}

//Remove owner entities
for (Video v : videoList) {
    Session sess = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = sess.beginTransaction();
    sess.delete(v);
    tx.commit();
    sess.close();
}