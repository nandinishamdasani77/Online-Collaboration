package online.com.collaborative.initializer;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import online.com.collaborative.config.HibernateConfig;
import online.com.collaborative.config.MvcConfig;
import online.com.collaborative.filter.CORSFilter;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//all configuration related class here
		
		return new Class[] {HibernateConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MvcConfig.class};
		
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	
	protected Filter[] getServletFilters()
	{
		return new Filter[]{new CORSFilter()};
	}

}
