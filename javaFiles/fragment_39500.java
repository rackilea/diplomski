public class DogService{
  Repository repository;
  public DogService(Repository repo){
    this.repository = repo;
  }

  public List<dogs> getAllDogs(){
    return this.repository.getAll();
  }
}