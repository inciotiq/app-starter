package com.iotiq.appstarter.commons;

import org.springframework.data.jpa.domain.Specification;

import static com.iotiq.appstarter.commons.util.NullHandlerUtil.setIfNotNull;


public interface NamedSearchRequest<T> extends SearchRequest<T> {

    String getName();

    @Override
    default Specification<T> buildSpecification() {
        return nameIsLike(getName());
    }

    default Specification<T> nameIsLike(String name) {
        return (root, query, cb) ->
                setIfNotNull(getName(), () -> cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
    }
}
