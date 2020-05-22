Page page = new Page();
Tag tag = new Tag();

//managing the both sides of the relationship
tag.setPage(page); //Setting Tags page field
page.getTags().add(tag); //Adding tag to the `Set<Tag>`