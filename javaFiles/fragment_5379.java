$separator = 'S39Er@T0R';
$postData = file_get_contents('php://input');
$splitPostData = explode($separator, $postData);
foreach($splitPostData as $postDataItem)
{
    // do something with $postDataItem
}