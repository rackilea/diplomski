$src1 = 'F:\Test\0374_1423730003.png';
$src2 = 'F:\Test\5030_1423722865.png'; // broken

$im = @imagecreatefrompng($src1);
if ($im)
    echo 'created img';
else
    echo 'not created, broken image';