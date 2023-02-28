package autnthentificaionwithjwttoken.jwttoken.service;

import autnthentificaionwithjwttoken.jwttoken.dao.RoleDao;
import autnthentificaionwithjwttoken.jwttoken.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public RoleService(RoleDao roleDao){ this.roleDao = roleDao;}

    public Role createRole(Role role){ return   roleDao.save(role);}

}
