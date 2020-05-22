BigDecimal noZero = b.stripTrailingZeros();
int scale = noZero.scale();
int precision = noZero.precision();    
if (scale < 0) { // Adjust for negative scale
    precision -= scale;
    scale = 0;        
}