use feature ':5.10';

$key = pack("H*","3cb37efae7f4f376ebbd76cd");

say decrypt("&4\=80CHB'");          # mentos
say decrypt(",#(0\=DM.'@ '8WQ2T");  # 07ch4ssw3bby
say decrypt("&7]P0G-#!");           # conf75

sub decrypt {
    $in = shift;
    $cipher = unpack("u", $in);
    $plain = $cipher^$key;
    return substr($plain, 0, length($cipher));
}