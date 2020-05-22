int sizePerPage=2;
int page=2;

int from = Math.max(0,page*sizePerPage);
int to = Math.min(list.size(),(page+1)*sizePerPage)

list.subList(from,to)