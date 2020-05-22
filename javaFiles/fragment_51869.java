@Override
public int compareTo(Object o) {
    int gendarComp = this.getGender().compareTo(((Employee)o).getGender());
    return (gendarComp != 0
               ? gendarComp
               : this.name.compareTo( ((Employee)o).getName() )
           );
}