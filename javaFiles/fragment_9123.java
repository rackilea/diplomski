weka.filters.supervised.instance.SMOTE


SMOTE smote=new SMOTE();
smote.setInputFormat(trains);       
Instances Trains_smote= Filter.useFilter(trains, smote);