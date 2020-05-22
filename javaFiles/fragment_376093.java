if (result != null) {
    System.out.println("result not null");
    if (repo == null)
        System.out.println("repo is null");
    else 
        repo.save(result);
}