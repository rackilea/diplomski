asynch_func1(x).flatMap{ y =>
  asynch_func2(x, y).map{ z =>
    synch_func3(x,y,z).flatMap{ w =>
      v = asynch_func4(x, y, z, w)
      print(v)
    }
  }
}