package com.iotiq.appstarter.user.messages;

import com.iotiq.appstarter.user.domain.Role;
import com.iotiq.appstarter.user.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto /*extends BaseDto*/ {
    private String username;
    private Role role;
    private String firstname;
    private String lastname;
    private String email;

    public static UserDto of(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setRole(user.getAccountSecurity().getRole());
        dto.setFirstname(user.getPersonalInfo().getFirstName());
        dto.setLastname(user.getPersonalInfo().getLastName());
        dto.setEmail(user.getPersonalInfo().getEmail());
        return dto;
    }
}
