@GET
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public UserAmountView find(@MatrixParam("userID") Integer userID,
                           @MatrixParam("balanceID") Integer balanceID) {
    if (null != userID && null != balanceID) {
        return findOne(userID, balanceID);
    } else {
        return findAll();
    }
}