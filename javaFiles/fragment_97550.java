$url='....bla bla';
$out=file_get_contents($url);
$dom=new DOMDocument();
@$dom->loadHTML($out);

$div=$dom->getElementById('yourid');
$value=$div->nodeValue;