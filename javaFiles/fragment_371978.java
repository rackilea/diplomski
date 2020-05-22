class Dentry {

    private String name;
    private String[] number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber(int index) {
        String value = null;
        if (index >= 0 && index < number.length) {
            value = number[index];
        }
        return value;
    }

    public void setNumbers(String... number) {
        this.number = number;
    }
}