package com.spring.session.example.springsessionexample;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DynamicJsonResponseAdvice extends AbstractMappingJacksonResponseBodyAdvice {
    private static final String INCLUSION_FILTER = "inclusion";
    private static final String WEB_PARAM_NAME = "include";
    private static final String DELI = ",";
    private static final String[] EMPTY = new String[]{};

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue container, MediaType contentType,
                                           MethodParameter returnType, ServerHttpRequest req, ServerHttpResponse res) {
        if (container.getFilters() != null) {
            // It will be better to merge FilterProvider
            // If 'SimpleFilterProvider.addAll(FilterProvider)' is provided in Jackson, it will be easier.
            // But it isn't supported yet.
            return;
        }
        HttpServletRequest baseReq = ((ServletServerHttpRequest) req).getServletRequest();
        String inclusion = baseReq.getParameter(WEB_PARAM_NAME);
        String[] attrs = StringUtils.hasText(inclusion) ? inclusion.split(DELI) : null;
        container.setFilters(configFilters(attrs));
    }

    private FilterProvider configFilters(String[] attrs) {
        if (attrs == null) {
            PropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(EMPTY);
            return new SimpleFilterProvider().addFilter(INCLUSION_FILTER, filter);
        } else {
            PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(attrs);
            return new SimpleFilterProvider().addFilter(INCLUSION_FILTER, filter);
        }
    }

}