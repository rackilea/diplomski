getDepth(1)
  getDepth(2)         // left
    getDepth(4)       // left
      getDepth(null)  // left base
      getDepth(null)  // right base
      return 0
    getDepth(5)       // right
      getDepth(null)  // left base
      getDepth(null)  // right base
      return 0
    return 0 + 1;
  getDepth(3)         // right
    getDepth(6)       // left
      getDepth(null)  // left base
      getDepth(null)  // right base
      return 0
    getDepth(7)       // right 
      getDepth(null)  // left base
      getDepth(null)  // right base
      return 0
    return 0 + 1;
  return 1 + 1;
return 2 + 1;