@Projection(name = "parentFullProjecton", types = { Parent.class })
interface ParentFullProjection{

    // inline the child collection
    Set<Child> getChildren();

    // other fields
}

@Projection(name = "groupFullProjection", types = { Group.class })
interface GroupFullProjection{

    //inline the parents collection and use the view which inlines Children
    Set<ParentFullProjecton> getParent();

    // other fields
}