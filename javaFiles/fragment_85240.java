@GET
@Timed
@Path("/sum")
public Sum calcSum(@QueryParam("a") int a, @QueryParam("b") int b) {
    System.out.println(a);
    System.out.println(b);

    return new Sum(counter.incrementAndGet(), a + b);
}