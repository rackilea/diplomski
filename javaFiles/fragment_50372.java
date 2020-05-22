public String toString(char delimiter) {
        final String QUOTE = "\"";
        final String EOLN = "\n";
        String output =   (this.customerId) + delimiter +
                         QUOTE + this.customerName + QUOTE + delimiter +
                         Integer.toString(this.customerProjects.size());

      output += EOLN ;
        for (Project project : customerProjects){
              output += QUOTE + project.getProjectId() + QUOTE;
              output +=   delimiter + QUOTE + project.getProjectName() + QUOTE;
              output +=   delimiter + QUOTE + project.getStartDate();
        output += EOLN;
        }
        return output;
     }