if($_SERVER['REQUEST_METHOD']=='POST') { /* ... */ }
else {
  http_response_code(400);
  // exit('Bad request method.');
  // or for a json response:

  echo json_encode([
    'success' => "0",
    'message' => "Bad Request Method used."
  ]);
}