hard( a, i ) ≡ hardHelper( a, a.length ).second( i )
hardHelper( a, 0 ) ≡ ( 1, { case 0 => [] } )
hardHelper( a, n + 1 ) ≡
  let t = a[n + 1].length
  and ( k, f ) = hardHelper( a, n )
  and k' = k * ( t - 1 )
  and f'( i ) =
        if ( i < k' )
        then easyInduction( f, 1 )( a, n + 1, i )
        else if ( k' <= i < k' + k )
        then easyInduction( f, 1 )( a[ 0..n ] ++ [ [ null ] ], n + 1, i - k' )
        else easyInduction( ( b, m, j ) => f( b, m, j + k ), 0 )( a, n + 1, i - k' - k )
   in ( k', f' )