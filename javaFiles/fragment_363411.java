try (BufferedReader br = new BufferedReader(new InputStreaReader(clientSOcket.getInputStream())) {

    for(String message; (message = br.readLine()) != null; ) {
        System.out.println("From client: " + message);
    }

} catch (IOException ioe) {
    ioe.printStackTrace();
}