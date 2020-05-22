User{id=1, info=UserInfo{info='First'}}
User{id=2, info=UserInfo{info='Second'}}
User{id=3, info=UserInfo{info='Third'}}
User{id=4, info=UserInfo{info='Fourth'}}
User{id=5, info=UserInfo{info='Fifth'}}
execution(d de.scrum_master.app.b.getUserInfo(Long))
  Cacheable scope:       session
  Cacheable unique name: userInfo
  Method line:           de.scrum_master.app.b.getUserInfo@27
UserInfo{info='First'}
execution(d de.scrum_master.app.b.getUserInfo(Long))
  Cacheable scope:       session
  Cacheable unique name: userInfo
  Method line:           de.scrum_master.app.b.getUserInfo@27
UserInfo{info='Third'}
execution(d de.scrum_master.app.b.getUserInfo(Long))
  Cacheable scope:       session
  Cacheable unique name: userInfo
  Method line:           de.scrum_master.app.b.getUserInfo@27
UserInfo{info='Fifth'}
execution(d de.scrum_master.app.b.getUserInfo(Long))
  Cacheable scope:       session
  Cacheable unique name: userInfo
  Method line:           de.scrum_master.app.b.getUserInfo@27
null