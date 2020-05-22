class Sample {

    private String name;
    private String sex;

    @Override
    public String toString() {
        return "name=" + name + "&" + "sex=" + sex;
    }
    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param sex
     *            the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

}