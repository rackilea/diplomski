/**
 * 
 */
package hu.flux.user;

/**
 * @author Brian Kessler
 *
 */
public class NamedPerson extends Person
{
    private String firstName = "";
    private String lastName = "";


    public String getFirst() { return this.firstName; }
    public void setFirst(String firstName) {this.firstName = firstName;}

    public String getLast() { return this.lastName; }
    public void setLast(String lastName) {this.lastName = lastName;}

    public String toString() {return (this.firstName + " " + this.lastName);}
}