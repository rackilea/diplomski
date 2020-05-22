public static <T extends Person>  Strategy<T> getStrategy(PersonType personType) {
        if(personType == STUDENT) return (Strategy<T>) new StudentStrategy();
        if(personType == TEACHER) return (Strategy<T>) new TeacherStrategy();
        return null;
    }
 }