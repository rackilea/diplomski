StringBuilder selectedThoughtsSB = new StringBuilder();
for(Integer key : selectedSet) {
    selectedThoughtsSB.append(twistedThoughtsMap.get(key) + "\n");
}

DistortionLogDetails.setText(selectedThoughtsSB.toString());