Criteria criteria1 = Criteria.where("dates").
    elemMatch(
      Criteria.where("value").exists(true).gt(DateTimeUtil.valueOf("1990-01-01 00:00:00 +00:00"))
      .and("name").exists(true).all("Birthday")
);
Criteria criteria2 = Criteria.where("dates").
    elemMatch(
      Criteria.where("value").exists(true).lt(DateTimeUtil.valueOf("1975-01-01 00:00:00 +00:00"))
       .and("name").exists(true).all("Mather's birthday")
);
Criteria criteria = new Criteria().andOperator(criteria1, criteria2);