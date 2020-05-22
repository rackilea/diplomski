@Override
public boolean equals(Department obj) {
    if (obj == null || !(obj instanceof Department)) {
        return false;
    }
    Department dept = (Department)obj
    return dept.id == id;
}