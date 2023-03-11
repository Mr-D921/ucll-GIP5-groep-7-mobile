package ucll.java.mobile.ucll_gip5_groep7.Models;

import java.util.Collection;

public class Role {
    private String name;
    private Collection<Privilege> privileges;
    private Collection<User> users;

    public Role(String name, Collection<Privilege> privileges, Collection<User> users) {
        this.name = name;
        this.privileges = privileges;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
