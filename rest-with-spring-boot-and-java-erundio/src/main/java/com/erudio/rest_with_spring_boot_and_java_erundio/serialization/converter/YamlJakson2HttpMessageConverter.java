package com.erudio.rest_with_spring_boot_and_java_erundio.serialization.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public class YamlJakson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

    public YamlJakson2HttpMessageConverter() {
        super(new YAMLMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL),
              MediaType.parseMediaType("application/x-yml"));
    }
}
