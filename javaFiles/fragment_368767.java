String catgId = "AB12545";
String excludeSubCatgId = "SAB09990";
DaoSession daoSession = ((App) getApplication()).getDaoSession();

List<Item> = daoSession.getItemDao().queryBuilder()
        .where(ItemDao.Properties.CategoryId.eq(catgId))
        .where(ItemDao.Properties.SubCategory.notEq(excludeSubCatgId))
        .whereOr(ItemDao.Properties.ItemTagCloud.like("%paint%"),
                 ItemDao.Properties.ItemTagCloud.like("%emulsion%"))
        .orderDesc(ItemDao.Properties.ItemPrice)
        .list();