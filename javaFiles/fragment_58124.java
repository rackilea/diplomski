GroupController gc=...
IGroup old=gc.findGroup(some field)
IGroup newGroup=(IGroup)old.clone(true);

ISort sort=new Sort();
sort.setSortField(field sorting on);
sort.setDirection(SortDirection);

newGroup.setSort(sort);
gc.modify(old,newGroup);