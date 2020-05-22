cRDD.map(s->{
            StringBuilder sb =new StringBuilder();
           Iterator<String> ite = s._2().iterator();
            while (ite.hasNext()){
                //change delimiter to colon(:) or some other character
                sb.append(ite.next()+":");
            }
            return new Tuple2<Long,String>(s._1(),sb.toString());
        }).pipe('myscript.sh');