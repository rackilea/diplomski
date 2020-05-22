func RGBtoCMYK(r : CGFloat, g : CGFloat, b : CGFloat) -> (c : CGFloat, m : CGFloat, y : CGFloat, k : CGFloat) {

    if r==0 && g==0 && b==0 {
        return (0, 0, 0, 1)
    }
    var c = 1 - r
    var m = 1 - g
    var y = 1 - b
    let minCMY = min(c, m, y)
    c = (c - minCMY) / (1 - minCMY)
    m = (m - minCMY) / (1 - minCMY)
    y = (y - minCMY) / (1 - minCMY)
    return (c, m, y, minCMY)
}