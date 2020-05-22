/**
 * @return Returns firstName and lastName
 */
@Transient
public String getFullName() {
    return firstName + ' ' + lastName;
}