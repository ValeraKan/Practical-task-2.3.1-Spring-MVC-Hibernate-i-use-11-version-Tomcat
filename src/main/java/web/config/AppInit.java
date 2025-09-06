package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class}; // основной конфиг приложения
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // можно оставить null, если все настройки в WebConfig
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // аналог <url-pattern>/</url-pattern>
    }
}
