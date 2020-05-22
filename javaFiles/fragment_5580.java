return userRepository.findByEmail(userDto.getEmail())
        //rethrow DB errors as BadRequestException, except user exists
        .onErrorResume(t -> Mono.error(new BadRequestException()))
        //throwing in map is converted to onError signal
        .map(ifItGoesThereItExist-> { throw new UserByEmailExistException(); })
        //switchIfEmpty to replace an empty source with a different Mono
        .switchIfEmpty(createUser(userDto))
        //at this point, map can only receive an onNext from the createUser
        .map(u -> new ResponseEntity(u, HttpStatus.CREATED))
        ;