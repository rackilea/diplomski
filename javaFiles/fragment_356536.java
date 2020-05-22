@Entity
class MyEntity implements Serialiable
{
    @Id String id;
    @Index String one;
    @Index String two;
    long three;
}