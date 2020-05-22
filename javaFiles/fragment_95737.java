try {
        WebDriverWait wait = new WebDriverWait(Drivers.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(position_header));
        wait.until(ExpectedConditions.visibilityOf(player_header));
        wait.until(ExpectedConditions.visibilityOf(num_of_players));
        wait.until(ExpectedConditions.visibilityOf(leaderboard_picks_header));
        System.out.println("Leaderboard is now displayed");

        return true;
    }
    catch (Exception e){
        return false;
    }