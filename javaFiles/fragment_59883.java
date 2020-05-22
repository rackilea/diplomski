import org.apache.shiro.SecurityUtils

class UserService {
    /**
     * for currently logged in user
     */
    def getLocalUserId(){
        def userName  = SecurityUtils.subject?.principal
        User.findByUsername(userName)
    }

    User getLocalUser(){
        getLocalUserId()
    }
}