package com.andres.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// clase se conecta con los sources de textos properties
// classplath es src/main/resources o recursos

@Configuration
@PropertySources({
	@PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {

}
