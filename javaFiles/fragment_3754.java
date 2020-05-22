@Entity
@Table(name = "MarketPrice")

public class MarketPrice {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "itemId")
private Long itemId;

@Column(name = "analysisDate")
private Date analysisDate;

@Column(name = "marketName")
private String marketName;

@Column(name = "category")
private String category;

@Column(name = "marketPlace")
private String marketPlace;

@Column(name = "state")
private String state;

@Column(name = "district")
private String district;

 @Transient
 public Items currentItem;

@Column(name = "itemName")
public String getItemName() {
    return this.currentItem.itemName;
}

@Column(name = "unitofPrice")
public String getUnitofPrice() {
    return this.currentItem.unitofPrice;
}

@Column(name = "minimumPrice",columnDefinition = "Float(10,2)")
public Float getMinimumPrice() {
    return this.currentItem.minimumPrice;
}

@Column(name = "maximumPrice",columnDefinition = "Float(10,2)")
public Float getMaximumPrice() {
    return this.currentItem.maximumPrice;
}

@Transient
public ArrayList<Items> marketPrices;