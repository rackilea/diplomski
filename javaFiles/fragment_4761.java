$billing_array = array(
    "first_name"=> "MG",
    "last_name"=> "Shah",
    "company"=> "",
    "street_1"=> "12345 W Anderson Ln",
    "street_2"=> "",
    "city"=> "Austin",
    "state"=> "Texas",
    "zip"=> "78757",
    "country"=> "United States",
    "country_iso2"=> "US",
    "phone"=> "",
    "email"=> "a@example.com"
);

$shipping_array = array(
    array( "first_name"=> "MG",
    "last_name"=> "Shah",
    "company"=> "",
    "street_1"=> "12345 W Anderson Ln",
    "street_2"=> "",
    "city"=> "Austin",
    "state"=> "Texas",
    "zip"=> "78757",
    "country"=> "United States",
    "country_iso2"=> "US",
    "phone"=> "",
    "email"=> "a@example.com"
    )
    ,);

$products_array= array();

for($i=0;$i<sizeof($products);$i++){

$products_array[] = array( 'product_id' => $products[$i]['products_id'],
                            'quantity'  => $products[$i]['products_qty']
);

}

$createFields= array(
                        "customer_id" => 0,
                        "status_id"=> 10,
                        "billing_address"=> $billing_array,
                        "shipping_addresses"=>$shipping_array,
                        "products"=>$products_array,
                        "external_source"=> "POS"
                    );
    $data_array_jason = json_encode($createFields);
    $products_passed = Bigcommerce::createOrder($data_array_jason);