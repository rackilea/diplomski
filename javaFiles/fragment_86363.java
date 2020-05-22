enum ContactRelationType {

    Friend,
    Familiar,
    Ignored,
    Unknown,
    Guild,
    Officers,
    Academy,
    Community,
    System;

    public boolean isRoomRelation() {
        return RoomContacts.contains(this);
    }
}

static final Set<ContactRelationType> RoomContacts = EnumSet.of(
        ContactRelationType.Guild,
        ContactRelationType.Officers,
        ContactRelationType.Academy,
        ContactRelationType.Community,
        ContactRelationType.System);