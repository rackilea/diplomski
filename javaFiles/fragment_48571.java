String userRole = "development";

List<RoleRepresentation> roleRepresentationList = userResource.roles().realmLevel().listAvailable();

for (RoleRepresentation roleRepresentation : roleRepresentationList)
  {
    if (roleRepresentation.getName().equals(userRole))
      {
        userResource.roles().realmLevel().add(Arrays.asList(roleRepresentation));
        break;
     }
  }