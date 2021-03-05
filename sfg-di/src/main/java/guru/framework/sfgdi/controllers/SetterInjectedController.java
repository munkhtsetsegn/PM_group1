package guru.framework.sfgdi.controllers;

import guru.framework.sfgdi.services.GreetingService;

public class SetterInjectedController {
    private GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
