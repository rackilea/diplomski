if (bindingResult.hasErrors()) {
        String error = bindingResult.getAllErrors().get(0).getDefaultMessage();

        if (bindingResult.getAllErrors().size() == 1) {
            return new ResponseEntity<>(responseBuilder.build("02", error), status);

        } else {
            return new ResponseEntity<>(
                    responseBuilder.build("02", "mandatory parameters can not be 
            empty, null or invalid"), status);

        }
    }