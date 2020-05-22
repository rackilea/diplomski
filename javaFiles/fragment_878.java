// TODO: execute the count query here to determine totalResults
int totalPages = Math.ceil(totalResults / pageSize);
// show first page by default
int firstResult = 0;
if (currentPage >= 0 && currentPage < totalPages) {
    firstResult = currentPage * pageSize;    
}
// the number of items might be less than the page size (i.e. on the last page)
int count = Math.min(pageSize, totalResults - firstResult);        
// TODO: execute the list query here to get a page of data