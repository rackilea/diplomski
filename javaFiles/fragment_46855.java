Element featureImage = document.select("div.featurebox-image")
            .first();
    String temp = featureImage.getElementsByAttribute("style")
            .toString();
    // URL of image
    imageStrg = temp
            .substring(temp.indexOf("(") + 1, temp.indexOf(")"));