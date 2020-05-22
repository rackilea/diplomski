enum Gender {
    MALE, FEMALE, UNKNOWN;
}

interface Person {
    void setGender(Gender gender);
    Gender getGender();
}

class PersonImpl implements Person {
    private Gender gender;

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }
}