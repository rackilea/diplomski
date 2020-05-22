//since you are not passing any parameter we can send null
    String absoluteUrl = RequestCycle.get().getUrlRenderer().renderFullUrl(
                            Url.parse(urlFor(EditBookingSourcePage.class, null).toString())); 


StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<a href=");
                stringBuilder.append(absoluteUrl);
                stringBuilder.append("\">Clicca Qui!</a>");
          feedbackErrorPanel.info(stringBuilder);