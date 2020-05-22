constraint = constraint.toString().toLowerCase();
 FilterResults results = new FilterResults();
 filteredList = new ArrayList<>();
            for (Spielort ort : allDataList) {
                if (ort.getSpielort().toLowerCase().contains(constraint)) {
                    filteredList.add(ort);
                }
            }
            results.count = filteredList.size();
            results.values = filteredList;