public XXReturnXX createNews(){
     Transaction tx = DAOHelper.createTx();

     NewsDao newsDAO.insertNews(tx,..);
     AuthorDAO authorDAO.insertAuthor(tx,..)

     tx.commit()
}