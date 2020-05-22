try(...) {
    for(;;) {
        Ser s = (Ser)ois.readObject();
        System.out.println(s);
    }
} catch(EOFException e) {
    // normal loop termination
} catch(IOException | ClassNotFoundException e){
    // error
}