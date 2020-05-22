package test.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table ( name = "third" )
@DiscriminatorValue("3")
public class ThirdEntity extends ThirdEntityBase
{
    public ThirdEntity() {}
}