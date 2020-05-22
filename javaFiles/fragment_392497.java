function () { 
    $order_ids = array();
    array_push($order_ids, 'order id 1');
    array_push($order_ids, 'order id 2');

    return json_encode({'order_id', $order_id});
}