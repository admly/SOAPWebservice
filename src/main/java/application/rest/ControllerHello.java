package application.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ControllerHello {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public BasicJsonObject greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new BasicJsonObject(counter.incrementAndGet(),
                String.format(template, name));
    }
}
