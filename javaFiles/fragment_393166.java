try {
    mgr.merge(party);
    mgr.flush();           
} finally {
    mgr.close();
}