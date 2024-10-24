package hello.world;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {
    @Autowired
    private MeterRegistry registry;

    @GetMapping("/inc")
    public String hello() {
        registry.counter("hello_world").increment();
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

