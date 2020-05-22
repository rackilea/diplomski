package your.own.package;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import your.own.UserDAO;

public class UserDetailService implements UserDetailsService {
    private UserDAO dao = null;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String error = null;
        UserDetails result = null;

        if(StringUtils.isNotEmpty(username)){
            if(dao.findById(username) != null){
                List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_BASIC", "ROLE_ADMIN");
                result = new org.springframework.security.core.userdetails.User(username, "", authorities);
            }
        }else{
            error = "No se ha especificado login para el usuario.";
        }

        if(result == null){
            if(StringUtils.isEmpty(error)){
                error = String.format("No se encuentra ningún usuario con login %s", username);
            }

            throw new UsernameNotFoundException(error);
        }

        return result;
    }
}