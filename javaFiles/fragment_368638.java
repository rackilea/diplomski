//CREATE 
    @Headers("Content-type: application/json") 
    @POST("/courses/create/") 
    Observable<Course> createCourse(@Body Course CourseName);
//LIST 
@GET("/courses") 
    Observable<List<Course>> getCourses();