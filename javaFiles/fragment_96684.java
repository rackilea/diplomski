val obj = object : UtilsCallback{
        override fun onData(user: Users) {
            fullName!!.text = user.name
            firstName!!.text = user.name
            email!!.text = user.username
        }
    }

    Handler().postDelayed({
        user = userAccountController.getUserAccountController(token, obj)
    }, 50)
}