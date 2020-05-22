// common interface to Student and Developer classes
interface Datable {
    LocalDate getStartDate();
}
// dev class implementing "datable"
class Developer implements Datable {
    @Override
    public LocalDate getStartDate() {
        // TODO Auto-generated method stub
        return null;
    }
}
// student class implementing "datable"
class Student implements Datable {
    @Override
    public LocalDate getStartDate() {
        // TODO Auto-generated method stub
        return null;
    }
}
// parameter interpreted as list of super type to both dev and student
private LocalDate[][] getArrayOfTimespan(List<Datable> args)
{
    for (Datable d: args) {
        // TODO something
        LocalDate foo = d.getStartDate();
    }
    // TODO return something
    return null;
}