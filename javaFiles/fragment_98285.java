// From http://www.rapidtables.com/convert/color/cmyk-to-rgb.htm
func CMYKtoRGB(c : CGFloat, m : CGFloat, y : CGFloat, k : CGFloat) -> (r : CGFloat, g : CGFloat, b : CGFloat) {
    let r = (1 - c) * (1 - k)
    let g = (1 - m) * (1 - k)
    let b = (1 - y) * (1 - k)
    return (r, g, b)
}