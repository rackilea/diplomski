public void listNotes(){
    int i = 0;
    for(String note : m_notes) { 
        System.out.println(""+i+":"+note);
        i++;
    }
}