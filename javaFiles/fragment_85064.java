conf.setClass("mapreduce.map.class", 
              Class.forName("reza.rCloud.Mapper_Reducer_Classes$Mapper_Class"),
              Mapper.class);

conf.setClass("mapreduce.reduce.class",
              Class.forName("reza.rCloud.Mapper_Reducer_Classes$Reducer_Class"),
              Reducer.class);