INSERT INTO order (
     order_id,
     amount,
     location,
     items,
     status,
     message
 ) VALUES (
    e7ae5cf3-d358-4d99-b900-85902fda9bb0,
    5,
    'San Jose', 
     [
       {qty:2, name:'mocha', milk_type:'whole', size:'small', price:2.5}
     ],
     'PLACED',
     'order is in process'
);