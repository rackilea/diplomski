public final class MyImmutableDepartment {
    private final MyImmutableLab lab;
    private final String departmentId;

    public MyImmutableDepartment(Department thirdPartyMutableDepartment) {
        this.departmentId = thirdPartyMutableDepartment.getId();
        this.lab = new MyImmutableLab(thirdPartyMutableDepartment.getLab());
    }

    // getters and the MyImmutableLab class left as an exercise
}