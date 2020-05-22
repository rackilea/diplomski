fun getPackageHash() {
        try {
            @SuppressLint("PackageManagerGetSignatures")
            val info = context.packageManager.getPackageInfo(
                    "your package name",//give your package name here
                    PackageManager.GET_SIGNATURES)
            for (signature: Signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())

                Log.d("LinkedInSignInManager", "Hash  : " + Base64.encodeToString(md.digest(), Base64.NO_WRAP))//Key hash is printing in Log
            }
        } catch (e: PackageManager.NameNotFoundException) {
            Log.d("LinkedInSignInManager", e.message, e)
        } catch (e: NoSuchAlgorithmException) {
            Log.d("LinkedInSignInManager", e.message, e)
        }
    }