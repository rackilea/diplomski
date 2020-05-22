val timerTask = object : TimerTask() {
    override fun run() {
        Log.d("letsSee", "PIKABOO") // it's getting printed

        menuView.post{

      QBadgeView(this@Stackoverflow).bindTarget(menuView!!.getChildAt(3)).badgeNumber = 7

        }
    }