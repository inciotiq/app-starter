package com.iotiq.appstarter.user.messages;


import com.iotiq.appstarter.commons.PageableRequest;
import com.iotiq.appstarter.commons.SearchRequest;
import com.iotiq.appstarter.user.domain.Person_;
import com.iotiq.appstarter.user.domain.User;
import com.iotiq.appstarter.user.domain.User_;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static com.iotiq.appstarter.commons.util.NullHandlerUtil.setIfNotNull;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserFilter extends PageableRequest implements SearchRequest<User> {
    String name;

    @Override
    public Specification<User> buildSpecification() {
        return fieldNameIsLike(name, Person_.FIRST_NAME)
                .or(fieldNameIsLike(name, Person_.LAST_NAME))
                .or(fieldNameIsLike(name, User_.USERNAME));
    }

    private Specification<User> fieldNameIsLike(String name, String fieldName) {
        return (root, query, cb) ->
                setIfNotNull(getName(), () -> cb.like(cb.lower(root.get(fieldName)), "%" + name.toLowerCase() + "%"));
    }


}
