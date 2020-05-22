ObjectId masterId = git.getRepository().exactRef("refs/heads/master").getObjectId();
Date since = new SimpleDateFormat("yyyy-MM-dd").parse("2017-08-01");
Date until = new SimpleDateFormat("yyyy-MM-dd").parse("2017-08-10");
RevFilter between = CommitTimeRevFilter.between(since, until);
for (RevCommit commit : git.log().add(masterId).setRevFilter(between).call()) {
    System.out.println(  "* "
                       + commit.getId().getName()
                       + " "
                       + commit.getShortMessage());
}