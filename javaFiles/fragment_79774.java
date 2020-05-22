if (Objects.requireNonNull(preferences.getString("rank", "")).equalsIgnoreCase("Recruit")
            && position <= 5) //will check the item position
    {
        //setAlpha or do anything you want if the Rank is Recruit and position is lesser or equal to 5
        holder.img.setAlpha(0.2f);
    } else
    {
        //else do the remaining part
    }

    return view;