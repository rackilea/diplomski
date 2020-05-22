public void post(@Context ContainerRequest request){
  MyEntity entity = null;
  if(request.hasEntity()){
    entity = request.readEntity(MyEntity.class);
  }
  //use the optional entity.
}