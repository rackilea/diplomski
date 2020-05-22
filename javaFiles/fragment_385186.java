board = Array.new(h) {|y|
  Array.new(w) {|x|
    (x+y)%2
  }
}
#or (this time inlined)
board = (0...h).map{|x| (0...w).map{|y| (x+y)%2 }}