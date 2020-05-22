class StatisticFrame {

     private TargetFrame targetObject = null;

     public StatisticFrame (TargetFrame obj) {
          this.targetObject = obj;
     }      

     public void Send (Object stats) {
          object stats = GetStatsObject(); // this will create and returns stats object
          targetObject.SetStatsObject(stats);
     }

     //... 
 }