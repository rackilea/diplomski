switch (type) {
    case 1: {
        String name = (String) respone.get("name");
        user.setName(name);
        break;
    }
    case 2: {
        String surname = (String) respone.get("surname");
        user.setSurname(surname);
        break;
    }
    ...
}