tx.begin();
Tag tag = new Tag();
Movie movie = new Movie();
Studio studio = new Studio();
Site site = new Site();

tag.setMovies(new HashSet<>(Arrays.asList(movie)));
tag.setStudios(new HashSet<>(Arrays.asList(studio)));
tag.setSites(new HashSet<>(Arrays.asList(site)));

site.setMovies(new HashSet<>(Arrays.asList(movie)));
studio.setMovies(new HashSet<>(Arrays.asList(movie)));
em.persist(movie);
em.persist(site);
em.persist(studio);
em.persist(tag);
tx.commit();
em.clear();

List<Tag> r = em.createQuery("select distinct t from Tag t left join fetch t.movieTags left join fetch t.studioTags left join fetch t.siteTags", Tag.class).getResultList();
System.out.println(r.get(0) 
        + Arrays.toString(r.get(0).getMovies().toArray())
        +":"+Arrays.toString(r.get(0).getStudios().toArray())
        +":"+Arrays.toString(r.get(0).getSites().toArray()));