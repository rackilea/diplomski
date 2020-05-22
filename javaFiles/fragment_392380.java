$res = mysqli_query($con,$sql);
$data=array();
while($row=mysqli_fetch_array($res)){
    $data[] = $row;
}
echo json_encode($data);