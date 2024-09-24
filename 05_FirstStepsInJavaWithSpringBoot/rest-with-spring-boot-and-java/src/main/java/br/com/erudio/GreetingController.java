package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//classes com esta annotation são responsáveis por definir os endpoints de requisições http
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	//mocka um novo id a cada chamada
	private final AtomicLong counter = new AtomicLong();
	
	//mapeia requisições http para métodos especificos em controllers
	@RequestMapping("/greeting")
	public Greeting greeting(
			//parametro opcional, caso não seja passado na url, será setado o valor default
			@RequestParam(value = "name", defaultValue = "World")
			String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
