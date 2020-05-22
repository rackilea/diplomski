private function java_multi($large_a,$large_b)
{
    $mul_str = bcmul($large_a,$large_b);
    $hex = $this->dec2hex($mul_str);
    $hex = substr($hex,-16);
    return (int) $this->hex2dec($hex);
}