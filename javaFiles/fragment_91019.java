for (int j = 0; j<clockwiseMoves.length; j++){

  if (cwMethods[j].equals("F")){
    originalRubik = originalRubik.frontfaceRight();
  }

  else if (cwMethods[j].equals("R")){
    originalRubik = originalRubik.rightfaceRight();
  }

  else if (cwMethods[j].equals("U")){
    originalRubik = originalRubik.upfaceRight();
  }

  else if (cwMethods[j].equals("L")){
    originalRubik = originalRubik.leftfaceRight();
  }

  else if (cwMethods[j].equals("B")){
    originalRubik = originalRubik.backfaceRight();
  }

  else if (cwMethods[j].equals("D")){
    originalRubik = originalRubik.downfaceRight();
  }
}

System.out.println(originalRubik);