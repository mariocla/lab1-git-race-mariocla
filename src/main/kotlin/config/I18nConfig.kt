package es.unizar.webeng.hello.config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.CookieLocaleResolver
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import java.util.*

/**
 * Configuración de Internacionalización (i18n) para la aplicación web.
 *
 */
@Configuration
class I18nConfig : WebMvcConfigurer {

    /**
     * Define el bean `MessageSource` que carga los archivos de mensajes
     * para distintos idiomas.
     *
     * @return una instancia de `MessageSource` capaz de recargar archivos de mensajes.
     */
    @Bean
    fun messageSource(): MessageSource {
        val messageSource = ReloadableResourceBundleMessageSource()
        messageSource.setBasename("classpath:messages")
        messageSource.setDefaultEncoding("UTF-8")
        return messageSource
    }

    /**
     * Define el bean `LocaleResolver`, que decide cómo recordar el idioma
     * seleccionado por el usuario entre peticiones.
     *
     * @return un `LocaleResolver` que almacena la preferencia del idioma en una cookie.
     */
    @Bean
    fun localeResolver(): LocaleResolver {
        val localeResolver = CookieLocaleResolver("LANGUAGE")
        localeResolver.setDefaultLocale(Locale.ENGLISH)  // Usar el método setter público
        return localeResolver
    }

    /**
     * Define el interceptor `LocaleChangeInterceptor` para permitir
     * cambiar el idioma mediante un parámetro en la URL.
     *
     * @return un interceptor que lee el parámetro `lang` de la petición y ajusta el locale.
     */
    @Bean
    fun localeChangeInterceptor(): LocaleChangeInterceptor {
        val interceptor = LocaleChangeInterceptor()
        interceptor.paramName = "lang"
        return interceptor
    }

    /**
     * Registra los interceptores definidos en la configuración web.
     *
     * @param registry el registro de interceptores proporcionado por Spring MVC.
     */
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(localeChangeInterceptor())
    }
}
