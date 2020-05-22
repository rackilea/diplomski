int HR_Score = HR < 41   ? 2 : 
              (HR < 51)  ? 1 : 
              (HR < 101) ? 0 : 
              (HR < 111) ? 1 : 
              (HR < 129) ? 2 :
                           3;