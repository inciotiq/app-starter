package com.iotiq.appstarter.commons;

import org.springframework.data.jpa.domain.Specification;

public interface SearchRequest<T> {
    Specification<T> buildSpecification();
}
