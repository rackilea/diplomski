//Remove Shape
public void removeShape(Shape aShape)
{
    for(int i=0;i<shapes.length;i++)
    {
        if(shapes[i] != null && Shape.compare(shapes[1].name, aShape.name))
        {
            shapes[i] = null;
            return;
        }
    }
    System.out.println("Cannot find that shape.");
}