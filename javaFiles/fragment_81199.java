User owner = new User();
owner.setId("generated_by_server_0001")
owner.setName("user");
...
// do this _before_ the create of Artwork
userDao.create(owner);

Artwork artwork = new Artwork();
artwork.setName("name");
...
artwork.setOwner(owner);
artworkDao.create(artwork);