class Group {
    String name
    Role role

    static belongsTo = [boss: Group]
    static hasMany = [children: Group, supporters: Group]

    static mapping = {
        table 'groups'
    }

    static mappedBy = [children  : "none",
                       supporters: "none"]

    static constraints = {
        boss nullable: true
        role nullable: true
        supporters validator: { supporters, group ->
            supporters?.each { Group supplier ->
                if (supporters.role != Role.OPS) {
                    return "domain.not.supporters.object"
                }
            }
            return true
        }
    }

}

enum Role {
    MANAGER, LEADER, DEVELOPERS, OPS
}