function xor_this($string,$key) {

 // Our plaintext/ciphertext
 $text =$string;

 // Our output text
 $outText = '';

 // Iterate through each character
 for($i=0;$i<strlen($text);)
 {
     for($j=0;($j<strlen($key) && $i<strlen($text));$j++,$i++)
     {
         $outText .= $text{$i} ^ $key{$j};
         //echo 'i='.$i.', '.'j='.$j.', '.$outText{$i}.'<br />'; //for debugging
     }
 }  
 return $outText;
}

//The sender chooses a private encryption key s and a corresponding decryption key t. The sender encrypts the message m with the key s and sends the encrypted message E(s,m) to the receiver.
//The receiver chooses a private encryption key r and a corresponding decryption key q and super-encrypts the first message E(s,m) with the key r and sends the doubly encrypted message E(r,E(s,m)) back to the sender.
//The sender decrypts the second message with the key t. Because of the commutativity property described above D(t,E(r,E(s,m)))=E(r,m) which is the message encrypted with only the receiver's private key. The sender sends this to the receiver.

$senderkey=base64_encode('chicken');
$receiverkey=base64_encode('ardvark');

$itemwewanttoshare='hello darling';
echo'$itemwewanttoshare: '.$itemwewanttoshare.'<BR>';
$packet1=xor_this($itemwewanttoshare,$senderkey);
echo'$packet1: '.$packet1.'<BR>';

$packet2=xor_this($packet1,$receiverkey);
echo'$packet2: '.$packet2.'<BR>';

$packet3=xor_this($packet2,$senderkey);
echo'$packet3: '.$packet3.'<BR>';

$packet4=xor_this($packet3,$receiverkey);
echo'$packet4: '.$packet4.'<BR>';