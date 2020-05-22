public class PointerConverter implements AttributeConverter<Point, String> {
   @Override
   public String converToDatabaseColumn(Point point) {
     // read the x, y, z, construct a string delimited by some character and
     // return the value.  Hibernate will store this in your column.
   }

   @Override
   public Point convertToEntityAttribute(String value) {
     // split the value by the delimiter and construct a Point.
     // return the constructed Point to be set in the entity.
   }
}