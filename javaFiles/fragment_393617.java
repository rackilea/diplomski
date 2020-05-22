depots[] = loadDepots();
depotsSpinner.setAdapter();
depotsSpinner.setSelected(0);

practice[] = loadPractice(depots[0]);
practiceSpinner.setAdapter();
practiceSpinner.setSelected(0);

address[] = loadAddress(depots[0], practice[0]);
addressSpinner.setAdapter();
addressSpinner.setSelected(0);