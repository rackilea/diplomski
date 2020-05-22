if(country.get(i).countryName.equals(choices)){
            strB.append("<option selected='selected'>" + country.get(i).countryName+"</option>");
            System.out.println(choices + " pareil " + country.get(i).countryName);
        }else{
            strB.append("<option>" + country.get(i).countryName+"</option>");
            System.out.println(choices + " " + country.get(i).countryName);
        }