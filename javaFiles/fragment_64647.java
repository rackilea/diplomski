/**
 * Tries to get the service request DAO from the ItemHolder, if it is not present there, it will try to get it from the argument.
 * If no service request found then CancellationException is thrown.
 *
 * In case both are present takes precedence the one in the ItemHolder object.
 *
 * @param itemHolderParameter the holder to be checked.
 * @param serviceRequestDAO in case no service request dao is found in the holder, this will be used.
 * @return ServiceRequestDAO guaranteed not null object.
 * @throws CancellationException in case no service request DAO was retrieved.
 * @throws IllegalArgumentException in case itemHolderParameter is null.
 */
public static ServiceRequestDAO getServiceRequestDAO(final ItemHolder itemHolderParameter, final ServiceRequestDAO serviceRequestDAO){
    return Optional.ofNullable(Optional.ofNullable(itemHolderParameter).map(ItemHolder::getServiceRequestDAO).orElse(serviceRequestDAO)).orElseThrow(() -> new CancellationException("No service request could be retrieved."));
}