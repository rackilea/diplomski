@Entity
class Product
{
@Id
int id;
String name;
@Formula("(select pp.price from PRODUCTPRICING pp where pp.PId = id and today() > pp.startDate AND today() < pp.endDate )")
double price;
}