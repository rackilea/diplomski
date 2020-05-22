public class AdminDaoOrmLite implements AdminDao {
    @Nullable
    private DatabaseHelper databaseHelper = null;
    @Nullable
    private Dao<Admin, Integer> adminDao = null;
    public Admin login(int pdaSeqNo, int sectionSeqNo, @NonNull String adminId, String adminPwd, String corpCode) {
        String sql = context.getResources().getString(R.string.sql_login)
                .replace("@pdaSeqNo", String.valueOf(pdaSeqNo))
                .replace("@sectionSeqNo", String.valueOf(sectionSeqNo))
                .replace("@adminId", adminId)
                .replace("@adminPwd", hashedPassword(adminPwd,corpCode));
        try {
            return adminDao.queryRaw(sql, adminDao.getRawRowMapper()).getFirstResult();
        } catch (SQLException e) {
            LOG.error(e);
        }
    }