#{list celibs}
        <li class="listCelibs">
            #{encart.moreInfoProfileSwitch
            index:_,
            owner:_,
            index:_.id,
            lang:'fr',
            mainPhoto:_.getProfileImage(),
            dateVision:_.getDateVision(),
            age:_.getAge(),
            taggedById:userSession,
            fadeToggleId:'more_info_user_' + _.id /}

            <a href="#more_info_user_${_.id}" class="ubeLightBox"><img width="263px" height="215px" src="${_.getProfileImage()}"></a>
            <p class="name">${_.nickName} <span>${_.getAge()} &{'rdv.rdvProposition.profile.age_' + _.mySex.keyName}</span></p>
            <a href="#more_info_user_${_.id}" class="ubeLightBox link1">&{'rdv.rdvProposition.profile.discover_' + sex}</a>

            <p class="askInterest">Intéressé ?</p>
            <button class="No">NON</button>
            <button class="Yes">OUI</button>
            // put hidden input here
            <input type="hidden" class="personId" value="${_.id}">

        </li>

    #{/list}