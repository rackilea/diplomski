new Random().ints(20, 0, 2).mapToObj(i -> (Either<String,Integer>)(i==0?
  Either.left("left value (String)"):
  Either.right(42)))
.forEach(either->either.apply(
  left ->{ System.out.println("received left value: "+left.substring(11));},
  right->{ System.out.println("received right value: 0x"+Integer.toHexString(right));}
));