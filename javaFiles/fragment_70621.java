return OptionalsUtils.toOptional(this.getBuiltMovieRoomPersistentDatabase())
        .map(builderObj -> {
            System.out.println("Its true here.");
            return builderObj.isOpen();
        })
        .orElseGet(() -> {
            System.out.println("Its false here");
            return false;
        });