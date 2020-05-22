ToDoes tds = target.path("rest").path("hello").request()
                        .accept(MediaType.TEXT_XML).get(ToDoes.class);

List<ToDoes.ToDo> l = tds.getToDo() ;

for (int i = 0; i < l.size(); ++i)
{
    System.out.println( "Summary"+i+":" + l.get(i).getSummary());
    System.out.println( "Summary"+i+":" + l.get(i).getDescription());
}