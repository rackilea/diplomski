tx.begin();

  // we have to assign parent/child keys to enforce ancestor path
  Key parentKey = KeyFactory.createKey("A", A.getNaturalPK());
  a.setId(KeyFactory.keyToString(parentKey));

  // now build child key
  a.getB().getC().setId(KeyFactory.createKeyString(parentKey, "C", A.getNaturalPK()));

  pm.makePersistent(offerer);
  tx.commit(); // works.