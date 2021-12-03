package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDAO;
import web.entity.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public Role getRoleById(long id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDAO.getRoleByName(roleName);
    }

    @Override
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Override
    public void removeRole(long id) {
        roleDAO.removeRole(id);
    }

    @Override
    public Set<Role> getSetOfRoles(String[] roleSet) {
        return roleDAO.getSetOfRoles(roleSet);
    }

    @Override
    public Set<Role> setRoleByName(String name) {
        return roleDAO.setRoleByName(name);
    }
}
