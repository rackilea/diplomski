// define this top-level function in your ECryptSymmetricEncrypt.kt

@JvmSynthetic internal fun <T> encrypt(
                                       input:T, password: String, cipher:Cihper, 
                                       erl: ECryptResultListener, outputFile:File,
                                       getKey:(String,ByteArray)->SecretKeySpec){

  ECryptSymmetricEncrypt(input, password, cipher,
                { pass, salt -> getKey(pass, salt) }, erl, outputFile)
}