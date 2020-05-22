/**
* ASSUMPTION : the client Flex/Air apps set the desired userId (= filter) as a fillParameter of the
* DataService.fill() method. This will filter output based on {@link AbstractDto#getUserId()}.
*/

@Service
public final class DataPushServiceImpl implements DataPushService {
    private static final Logger LOG = Logger.getLogger(DataPushServiceImpl.class);
/* *********** V2 : DataServiceTransaction.createItem() ********* */
/**
 * Does the push of a single DTO.
 *
 * @param dto
 *            {@link AbstractDto} object. Contains the {@link AbstractDto#getUserId()} that is used by clients to
 *            filter data in the DataService.fill() method (used by the Assembler).
 *
 * @throws DsPushException
 *             if any error
 */
private boolean doPushViaTransaction(final AbstractDto dto) throws DsPushException {

    if (LOG.isDebugEnabled()) {
        LOG.debug("Sending message through DataServiceTransaction (see userId field) : " + dto.toString());
    }

    // One MUST instantiate a DataServiceTransaction to be able to send anything (NullPointerException)
    DataServiceTransaction dtx = null;
    boolean isOwnerOfTx = false;
    boolean isSent = false;
    try {
        // if already in an Assembler, we do have a tx ==> no commit nor rollback!
        dtx = DataServiceTransaction.getCurrentDataServiceTransaction();
        if (dtx == null) {
            // new one, no JTA ==> ourselves : commit or rollback
            isOwnerOfTx = true;
            //MessageBroker instantiated with SpringFlex is auto-named
            dtx = DataServiceTransaction.begin("_messageBroker", false);
        }

        isSent = this.doTransactionSend(dto, dtx);

    } catch (Exception e) {
        // Log exception, but no impact on the back-end business ==> swallow Exception
        LOG.error("Could not send the creation to LCDS", e);
        if (isOwnerOfTx) {
            dtx.rollback();
        }
    } finally {
        try {
            if (isOwnerOfTx && (dtx != null)) {
                dtx.commit();
            }
        } catch (Exception e) {
            // swallow
            LOG.error("Could not send the creation to LCDS (@commit of the DataServiceTransaction)", e);
        }
    }

    return isSent;

}

private boolean doTransactionSend(final AbstractDto dto, final DataServiceTransaction dtx) {

    boolean isSent = false;

    if (dto == null) {
        LOG.error("The given DTO is null! Nothing happens");

    } else {
        try {
            dtx.createItem(FlexUtils.DESTINATION_NAME__POC_DS, dto);
            isSent = true; // no problem
        } catch (Exception e) {
            // Log exception, but no impact on the business
            LOG.error("Could not send the creation to LCDS for DTO " + dto.toString(), e);
        } finally {
            if (LOG.isDebugEnabled()) {
                LOG.debug("DTO : " + dto.toString() + "\n sent : " + String.valueOf(isSent));
            }
        }
    }

    return isSent;
}

//implementation of DataPushService interface
/**
 * {@inheritDoc}
 *
 * @see DataPushService#pushNewDTo(AbstractDto, java.lang.Long)
 */
@Transactional(rollbackFor = DsPushException.class)
public boolean pushNewDTo(final AbstractDto dto, final Long subscriberId) throws DsPushException {
    return this.doPushViaTransaction(dto);
}
}