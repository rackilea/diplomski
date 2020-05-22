// Some resource method
@Path("data/find")
public static Ok<MyDataRep> findData(@Valid MyDataRequestBean form) {
    // find entity etc
    MyDataRep somePojo = ...;
    return Ok.entity(somePojo);
}