public List<FetchSubCategory> fetchSubCategory() throws SQLException, ClassNotFoundException, IOException {
        List<FetchSubCategory> groupList = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("select distinct e FROM FetchSubCategory e INNER JOIN e.subCategory m ORDER BY m.mainCategory");
            groupList = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return groupList;
    }