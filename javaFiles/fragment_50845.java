List<IDynamicAction<User>> actions = new ArrayList<IDynamicAction<User>>();
actions.add(new IDynamicAction<User>() {
@Override
public boolean select(User instance) {
    return count <= instance.getFSCount();
}

@Override
public String action(User t) {
    System.out.println("count <= instance.getFSCount()");
    return "count <= instance.getFSCount()";
}
});


actions.add(new IDynamicAction<User>() {
@Override
public boolean select(User instance) {
    return count <= instance.getTCount();
}
@Override
public String action(User t) {
    System.out.println("count <= instance.getTCount()");
    return " count <= instance.getTCount()";
}
});

actions.add(new IDynamicAction<User>() {
@Override
public boolean select(User instance) {
    return count <= instance.getOCount();
}
@Override
public String action(User t) {
    System.out.println("count <= instance.getOCount()");
    return " count <= instance.getOCount()";
}
});