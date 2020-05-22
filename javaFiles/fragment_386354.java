@Override
public int compareTo(Employee emp) {
    // compare IDs:
    int cmp = Integer.compare(id, emp.id);
    if (cmp != 0) {
        return cmp;
    }

    // compare ages:
    cmp = Integer.compare(age, emp.age);
    if (cmp != 0) {
        return cmp;
    }

    // compare names. Luckily, Strings are comparable:
    cmp = name.compareTo(emp.name);
    if (cmp != 0) {
        return cmp;
    }

    // compare salaries, using the builtin Long.compare:
    return Long.compare (salary, emp.salary);
}