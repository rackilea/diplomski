StringBuilder sb = new StringBuilder();
        sb.append("[");
        int num = 5;
        for(int i=0;i<num;i++)
        {
            sb.append("[");
            sb.append(new Date().getTime() + "," + (i+1));
            sb.append("]");
            if((i+1)<num)
                sb.append(",");
        }
        sb.append("]");