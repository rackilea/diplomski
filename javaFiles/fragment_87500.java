@javax.xml.bind.annotation.XmlType
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class Album 
{
   long version;

   String status;

   java.util.List<Row> rows;

}  


@javax.xml.bind.annotation.XmlType
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class Row 
{
   String areaId;

   String nameEng;

   String nameGer;
}