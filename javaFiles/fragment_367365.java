PackageManager pm = context.getPackageManager();

   PackageInfo info = pm.getPackageInfo( context.getPackageName(), PackageManager.GET_SIGNATURES );

   if ( info.signatures[ 0 ].toCharsString().equals( YOUR_SIGNATURE ) )
   {
     //signature is OK
   }