package test.entities;

import javax.persistence.Column;

public abstract class ThirdEntityBase extends SecondEntity
{
    public ThirdEntityBase() {}

    @Column (name = "column_c")
    private Integer columnC;

    public Integer getColumnC() { return this.columnC; }
    public void setColumnC(Integer columnC) { this.columnC = columnC; }
}