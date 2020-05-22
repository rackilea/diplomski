package testgrails12

    class Team {

    String name

    static mapping = {
        version false
    }

    static constraints = {
        name nullable: true
    }
}