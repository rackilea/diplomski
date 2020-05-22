// Java 8
IConfigRepo::findOne


// Java 7
// ??? because I don't know your type for ID
new Lookup<IConfigRepo, ???>() {
     @Override
     public Object lookup(IConfigRepo repository, ??? identifier) {
          return repo.findOne();
     }
}