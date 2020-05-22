@Transactional
public void create(Integer id, List<Integer> customerIDs) {

    Header header = headerService.findOne(id);
    // header is found, has multiple details

    // Remove the details
    for(Detail detail : header.getDetails()) {
        em.remove(detail);
    }

    // em.flush(); // In some case you need to flush, see comments below

    // Iterate through list of ID's and create Detail with other objects
    for(Integer id : customerIDs) {
        Customer customer = customerService.findOne(id);

        Detail detail = new Detail();
        detail.setCustomer(customer);
        detail.setHeader(header);  // did this happen inside you service?
        em.persist(detail);
    }
}