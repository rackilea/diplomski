$data = NULL;

$data['user_id'] = "6cdedfcc-ff55-449f-8362-af3ae0e04928";

$data_string = json_encode($data);                                                                               

$ch = curl_init(); 
curl_setopt($ch,CURLOPT_URL,'https://java-api-url/api');                                                     
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");                                                                     
curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string);                                                                  
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);   
curl_setopt($ch, CURLOPT_HTTPHEADER, array(                                                                          
    'Content-Type: application/json',                                                                                
    'Content-Length: ' . strlen($data_string))                                                                       
);                                                                                                                   

$result = curl_exec($ch);



print_r($result);