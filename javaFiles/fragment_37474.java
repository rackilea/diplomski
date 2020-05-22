public ArrayList<String> getweakAreaCount() {

        ArrayList<String> label = new ArrayList<>();
        for (int i = 0; i < weakAreaList.size(); i++)
            label.add(weakAreaList.get(i).getTopicNm());
        return label;
    }

xAxis.setValueFormatter(new IndexAxisValueFormatter(getweakAreaCount));