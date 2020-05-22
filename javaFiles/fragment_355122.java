if (outputTweet.getText() != null) {
        holder.text.setText(outputTweet.getText());
    } else {
        holder.text.setText("");
    }

    if (!outputTweet.getInfoText().equals("")) {
        holder.infoText.setVisibility(View.VISIBLE);
        holder.infoText.setText(outputTweet.getInfoText());
    } else {
        holder.infoText.setVisibility(View.GONE);
    }