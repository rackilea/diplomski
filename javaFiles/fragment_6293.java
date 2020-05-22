@Override
public String toString() {
  return "coupe:"
             + "\nmodel: " + coupeModel
             + "\nmiles: " + milesPattern.format(coupeMiles)
             + "\ngallons: " + coupeGallons;
}