rule testForGood
when
  $account: Account( $sub: subsections )
  exists SubSection( status == "GOOD" ) from $sub
then
  insertLogical( new AccountIsGood($account) );
end