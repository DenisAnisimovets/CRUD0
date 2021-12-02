package web.dao;

import web.entity.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface RoleDAO {
    Role getRoleByName(String name);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    Role getDefaultRole();

    void saveRole(Role role);

    void updateRole(Role role);

    void removeRole(long id);

    HashSet<Role> getSetOfRoles(String[] roleSet);

    public Set<Role> setRoleByName(String name, String[] rolesName);
}