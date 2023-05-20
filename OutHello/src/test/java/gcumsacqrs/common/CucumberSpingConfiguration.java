package gcumsacqrs.common;

import gcumsacqrs.OutHelloApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { OutHelloApplication.class })
public class CucumberSpingConfiguration {}
