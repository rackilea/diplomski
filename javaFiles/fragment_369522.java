@Path("test")
@RequestScoped
public class TestResource {

@Inject
ConnectionWrapper wrapper;

@Inject
DAOObject dao;

@Inject
DAOObject2 dao2;

@GET
@Produces(MediaType.TEXT_PLAIN)
public Response testMethod() throws Exception {
    try {
        wrapper.begin();
        DTOObject dto = new DTOObject();
        dto.setName("Name_1");
        dao.query(dto);
        DTOObject2 dto2 = new DTOObject2();
        dto2.setName("Name_2");
        dao2.query2(dto2);
        wrapper.commit();
    } catch (SQLException e) {
        wrapper.rollback();
    }
    return Response.ok("ALL OK").build();
}
}