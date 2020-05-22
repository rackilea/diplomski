SELECT 
    TreatmentRecords.DateGiven, TreatmentRecords.TimeGiven, 
    SInformation.Surname, SInformation.FirstNames, SInformation.CampusCode, 
    TreatmentRecords.Treatment, TreatmentRecords.[AmountGiven], TreatmentRecords.Diagnosis
FROM TreatmentRecords INNER JOIN SInformation
    ON TreatmentRecords.SID = SInformation.SID
WHERE TreatmentRecords.DateGiven >= #2015-03-01# 
    AND TreatmentRecords.DateGiven < #2015-04-01# 
    AND TreatmentRecords.SID <= 70000
GROUP BY 
    TreatmentRecords.DateGiven, TreatmentRecords.TimeGiven, 
    SInformation.Surname, SInformation.FirstNames, SInformation.CampusCode, 
    TreatmentRecords.Treatment, TreatmentRecords.[AmountGiven], TreatmentRecords.Diagnosis
ORDER BY 
    TreatmentRecords.DateGiven, SInformation.Surname, SInformation.FirstNames;