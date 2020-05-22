@RequestMapping("/stores")
    public List<Store> getStores(Principal principal){

        MySpringUser activeUser = (MySpringUser) ((Authentication) principal).getPrincipal();
        System.out.println(activeUser.getUsername());

        return storeRepository.findByMyUserId();

    }