public ArrayList<Projekt> getSavedArrayList() {
    ArrayList<Projekt> savedArrayList = null;
    try {
        // get the file and check if it exists before trying to read it
        File savedFile = new File(getActivity().getFilesDir(), FILENAME);
        if (savedFile.exists()) {
            // if the file containing the list exists, read it and return the list
            FileInputStream fis = getActivity().openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            savedArrayList = (ArrayList<Projekt>) ois.readObject();
            ois.close();
            fis.close();
        } else {
            // if it doesn't exist, return an empty list
            savedArrayList = new ArrayList<>();
        }
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace ();
    }
    return savedArrayList;
}