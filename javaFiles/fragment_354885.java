Parent parent = new Parent();
parent = parentDomainService.save(parent);
parent.setChildren(Lists.newArrayList(new Child(), new Child()));

for (Child child: parent.getChildren()) {
    child.setParentId(parent.getId());
} 

childDomainService.save(parent.getChildren());