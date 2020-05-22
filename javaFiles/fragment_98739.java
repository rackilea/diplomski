object Utils {


    internal interface Callback {
        fun onResult(infos: Array<MediaCodecInfo?>?)
    }


    internal class EncoderFinder(func : Callback) : AsyncTask<String,Void,Array<MediaCodecInfo?>?>(){

        var func : Callback = func


        override fun doInBackground(vararg params: String?): Array<MediaCodecInfo?>? {
            return findEncodersByType(params[0])
        }

        override fun onPostExecute(result: Array<MediaCodecInfo?>?) {
            func.onResult(result)
        }

    }

   internal fun findEncodersByTypeAsync(mimeType: String?, callback: (Array<MediaCodecInfo?>?) -> Unit){
    EncoderFinder(callback as Callback).execute(mimeType)
}


}