class User {
    String username
}

class TrainUser {
    static hasMany = [training: Training, user: User]
}

class Training {
    String name
}