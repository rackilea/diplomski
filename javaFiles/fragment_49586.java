@JoinColumn(name = "Supplier_Id",insertable=false,updatable=false)
private Supplier supplier;

@JoinColumns({
  @JoinColumn(name = "Supplier_Id",insertable=false,updatable=false),
  @JoinColumn(name = "Supplier_Contactperson_Id",insertable=false,updatable=false)
private SupplierContactperson supplierContactperson;

@Column(name="Supplier_Id")
private String supplier_id;
@Column (name = "Supplier_Contactperson_Id")
private String supplier_contact_Person_id;