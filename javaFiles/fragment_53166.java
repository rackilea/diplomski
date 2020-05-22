val cxt = requireContext() // one source of failure if context is null

lifecycleScope.launch {

    // Start loading the second animation in a background thread
    val spellStopAnimationJob: Deferred<AnimationDrawable> = async(Dispatchers.Default) {
        cxt.getDrawable(ctx.resources.getIdentifier(
            "${spellCasted}stop_anim",
            "drawable", ctx.packageName
        ) as AnimationDrawable
    }

    view.setImageResource(
       resources.getIdentifier(
                "${spellCasted}_anim",
                "drawable", cxt.packageName
            )
    )
    val x1 = startXposition
    val x2 = firstXdestination
    val initialAnimation = view.drawable as AnimationDrawable
        .apply { start() }
    view.visibility = View.VISIBLE
    ObjectAnimator.ofFloat(
        view,
        "translationX",
        x1.toFloat(),
        x2.toFloat()
    ).apply {
        duration = 900L
        interpolator = LinearInterpolator()
    }.runToCompletion()

    if (hasPost(splitSpell)) { //hasPost(..) check is there additional image to translate from x2 to x2 + 20
        initialAnimation.stop()

        // Wait for the animation to be loaded (hopefully it's already done so no hiccup)
        val stopAnimation = spellStopAnimationJob.await()
            .apply { start() }
        view.setImageDrawable(stopAnimation)
        ObjectAnimator.ofFloat(
            view, "translationX",
            x2.toFloat(),
            x2.toFloat() + 20f
        ).apply {
            duration = 1200
            interpolator = LinearInterpolator()
        }.runToCompletion()
    }

    setDefault(view, x1, isEnemy)//returns view to startPos
}