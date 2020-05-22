package test.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table ( name = "fourth" )
@DiscriminatorValue("4")
public class FourthEntity extends ThirdEntityBase
{
    public FourthEntity() {}
}