public interface NoteRepository extends JpaRepository<Note,Long> {

     List<Note> findByLastnameOrFirstnameStartingWith(String param1,String param2)

     static List<Note> findByContentContains(String content){
      findByLastnameOrFirstnameStartingWith(content,content);
   }
 }