package com.socialmedia.internationalization;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class Internationalization {

    private MessageSource messageSource;

    public Internationalization(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/get-internationalization")
    public String internationalizationTest(){

        Locale locale = LocaleContextHolder.getLocale();
       return messageSource.getMessage("good.morning.message",null,"Default Message",locale);

    }
}
