try {
                TypeFactory typeFactory = mapper.getTypeFactory();
                CollectionType collectionType = typeFactory.constructCollectionType(
                                                    List.class, Users.class);
                List<Users> usersList =  mapper.readValue(new File("list.json"), collectionType);     

            } catch (IOException e) {
                e.printStackTrace();
            }