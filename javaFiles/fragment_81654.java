String URL="https://blablabla.com\docs\"; //<---make sure that the PDF are listed and hosted here 
        // Declare list to add the files 
        ArrayList<String> pdfList = new ArrayList<String>(); 
        //Regex pattern will detect if the files end with .pdf or .PDF
        String regex = "^.*\\.(pdf|PDF)$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE|Pattern.DOTALL);