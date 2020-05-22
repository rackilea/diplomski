ArrayList<String> result = new ArrayList<String>();
// combine directory and file name like this
File f = new File(STORAGE_DIRECTORY, fileName);
// use try-with-resource here, like this:
try (BufferedReader br = new BufferedReader(new FileReader(f)))  {

    String sCurrentLine;

    while ((sCurrentLine = br.readLine()) != null) {
        result.add(sCurrentLine);
    }
    } catch (FileNotFoundException e) {
        // no need to create a new list
        return Collections.emptyList()
    } catch (IOException e) {
        return Collections.emptyList()
    }

    // you don't need to close the reader if you use try-with-resource

    return result;
}