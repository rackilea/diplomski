"insert into ParsonCollection (
    name,
    eye,
    hair,
    height
    weight
) values(" 
    + q_surround(Name) 
    + "," + q_surround(Eye) 
    + "," + q_surround(Hair) 
    + "," + q_surround(Height)
    + "," + q_surround(Weight)
+ ")";