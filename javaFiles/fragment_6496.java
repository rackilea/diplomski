package entities;

public class Point {

    private Long id;
    //Other fields.

    @ID
    @Column(PointTable.ID)
    public Long getId() {
        return id;
    }

    //Other getters and setters.
}