for (Long id : allRequiredIds) {
  if (!sessionFactory.getCache().containsEntity(Song.class, id)) {
    idsToQueryDatabaseFor.add(id)
  } else {
    songs.add(session.get(Song.class, id));
  }
}

List<Song> fetchedSongs = session.createCriteria(Song.class).add(Restrictions.in("id",idsToQueryDatabaseFor).list();
songs.addAll(fetchedSongs);