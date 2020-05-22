@RequestParam Optional<String> order


userRepository.findByName(find.orElse("_"),
                new PageRequest(page.orElse(0),5,
                        Sort.Direction.fromString(order), sort.orElse("name")));