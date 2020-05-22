public class FloatEncoder {

    public static void main(String args[]) {
        FloatEncoder encoder = new FloatEncoder();

        float [] floats = new float[] {12.45f, 34.6f, -32.456f, 12.98f};
        String encodedJson = encoder.encode(floats);
        System.out.println(encodedJson);
    }

    private String encode(float[] floats) {
        String rtn;
        DataHolder holder = new DataHolder();


        String audios = convertToBase64Bytes(floats);
        B64 b64 = new B64();
        b64.b64 = audios;
        holder.instances.add(b64);

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        rtn = gson.toJson(holder);

        return rtn;
    }

      public static String convertToBase64Bytes(float[] audio) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 * audio.length);
        for (int i = 0; i < audio.length; i++) {
          float amplitude = audio[i];  
          byteBuffer.putFloat(amplitude);
        }
        byte[] data = byteBuffer.array();
        String rtn = Base64.getEncoder().encodeToString(data);
        return rtn;
      }

      public static class DataHolder{
          public ArrayList<B64> instances = new ArrayList<>();
      }

      public static class B64{
          public String b64;
      }
}