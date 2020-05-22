List<Predicate> predicateList = new ArrayList<>();

predicateList.add(builder.equal(something.get("firstColumn"), firstValue));
predicateList.add(builder.equal(something.get("thirdColumn", thirdValue));
if(secondValue != 0) {
    predicateList.add(builder.equal(something.get("secondColumn", secondValue));
}

criteria.select(something.get("somethingId"))
        .where(predicateList.toArray(new Predicate[predicateList.size()]);