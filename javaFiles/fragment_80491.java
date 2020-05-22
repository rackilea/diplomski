MyPojo pojo = new MyPojo();
OtherPojo otherPojo = new OtherPojo();
OtherPojo otherPojo1 = new OtherPojo();

pojo.setOtherPojos(Arrays.asList(otherPojo, otherPojo1));

mongoTemplate.save(otherPojo);
mongoTemplate.save(otherPojo1);

mongoTemplate.save(pojo);