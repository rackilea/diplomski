@Entity
class B {
    @Id
    int id;

    @OneToOne 
    @MapsId
    A a
}