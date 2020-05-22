| <Y:"${"(<NAME)+ "}" >
        {
        String oldValue=image.toString();
        image.setLength(0);
        image.append(my_dict.get(oldValue));
        }