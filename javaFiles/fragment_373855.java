int counter = 0;
String temp = null;
final int BATCH_SIZE = 1000;
try (BufferedReader br = new BufferedReader(new FileReader(path)) {

    while ((temp = br.readLine()) != null) {
        text.append(temp);
        ++counter;

        /* Process In Batches */
        if(counter % BATCH_SIZE == 0) {
            /* Prepare & Append JSON Objects */
            obj = prepareAppendJSON(text.toString(), obj);
            /* Clear text */
            text.setLength(0);
        }
    }

    /* Last Iteration */
    obj = prepareAppendJSON(text, obj);
    text = new StringBuilder();

} catch (IOException ex) {
    ex.printStackTrace();
}