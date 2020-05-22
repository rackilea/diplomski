MSH   Message Header  
  SCH   Schedule Activity Information       
    [ { TQ1 } ] Timing/Quantity     
    [ { NTE } ] Notes and Comments for the SCH  
  [ {   --- PATIENT begin       
      PID   Patient Identification  
      [ PD1 ]   Additional Demographics     
      [ PV1 ]   Patient Visit       
      [ PV2 ]   Patient Visit - Additional Info     
      [ { OBX } ]   Observation/Result      
      [ { DG1 } ]   Diagnosis       
  } ]   --- PATIENT end     
  {     --- RESOURCES begin     
    RGS      Resource Group Segment     
    [ { --- SERVICE begin       
        AIS     Appointment Information - Service       
        [ { NTE } ] Notes and Comments for the AIS      
    } ] --- SERVICE end     
    [ { --- GENERAL_RESOURCE begin      
        AIG      Appointment Information - General Resource     
        [ { NTE } ] Notes and Comments for the AIG      
    } ] --- GENERAL_RESOURCE end        
    [ { --- LOCATION_RESOURCE begin     
        AIL      Appointment Information - Location Resource        
        [ { NTE } ] Notes and Comments for the AIL      
    } ] --- LOCATION_RESOURCE end       
    [ { --- PERSONNEL_RESOURCE begin        
        AIP   Appointment Information - Personnel Resource      
        [ { NTE } ] Notes and Comments for the AIP      
    } ] --- PERSONNEL_RESOURCE end      
  } --- RESOURCES end