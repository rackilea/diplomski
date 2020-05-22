// Removed extraneous brackets as well...
int x = p1.getCustomerUnit().getId().compareTo(p2.getCustomerUnit().getId());
if (x == 0) {
    return p1.getId().compareTo(p2.getId());
}
return x;