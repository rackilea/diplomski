else if(e.getActionCommand().equals("Save")){
        try {
            PrintWriter out = new PrintWriter("filename.txt");
            out.println(txtID.getText());
            out.println(txtName.getText());
            out.println(txtCourse.getText());
            out.println(txtProfessor.getText());
            out.println(txtHelp.getText()); 
            out.flush();

        } catch (FileNotFoundException ex) {
        }
    }