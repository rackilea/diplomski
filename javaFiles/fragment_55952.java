ArrayList<String> id_list;

for (List<String> sortedList : sorted) {
            for (String s : sortedList) {
                String delimiter = ",";
                String[] splitString = s.split(delimiter);
                String tempID = splitString[0];
                if(!id_list.Contains(tempID))
                {
                  id_list.Add(tempID);// duplicates wont add
                  perform calclulations with unique TempID

                }
            }
           s+=","+newColumn;
        }