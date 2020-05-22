rule "interesting user/product"
when
  SessionClock( $now: time )
  Purchase( $uid: userId, $purchases: purchasedProducts )
  ClickEvent( userId == $uid, $pid: productId,
              event == "FAVORITE" )
  not ClickEvent( userId == $uid, productId == $pid,
                  event == "REMOVE_FAVORITE" )     
  Product( id == $pid, $endDate: endDate )
  eval( endDateIsToday( $now, $endDate ) )
then
end

rule "make Collection" extends "interesting user/product"
when
  not Collection( userId == $uid )
then
  insert( new Collection( $uid ) )
end

rule "fill Collection" extends "interesting user/product"
when
  $coll: Collection( userId == $uid, products not contains $pid )
then
  modify( $coll ){ addProduct( $pid ) }
end