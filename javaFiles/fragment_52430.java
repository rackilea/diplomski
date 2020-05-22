class Professor{
    List< Student > students;
    …
    public void addStudent( Student student ){
        Objects.requireNonNull​( student , "Received NULL rather than a Student object. Message # 68a0ff63-8379-4e4c-850f-e4e06bd8378a." ) ;  // Throw an exception if passed a null object.
        Objects.requireNonNull​( this.students , "Collection of Student objects is NULL. Message # c22d7b22-b450-4122-a4d6-61f92129569a." ) ;  // Throw an exception if the `students` list is not established.
        this.students.add( student ) ;
    }
}