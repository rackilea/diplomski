interface Tagable {
 public doSomeThingWithTagList(); 
} 

class abstract Content implements Tagable {
 List<Tag> tagList; 
} 

class Video extend Content implements Tagable {
} 

class Book Tagable{ 
 List<Tag> tagList; 
} 

class Course Tagable {
   List<Video> videoList;
   List<Books> bookList;
   List<Tag> tagList 
}