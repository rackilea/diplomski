Credit c = new Credit()
Movie m = session.load(movieId);
Actor a = session.load(actorId);
c.setMovie(m);
c.setActor(a);
session.save(c);