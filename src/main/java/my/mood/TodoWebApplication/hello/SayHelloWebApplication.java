package my.mood.TodoWebApplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloWebApplication {

	// say-hello = "Hey there, Shrunal is here!"
	
	// http://localhost:8080/Say-Hello
	
	@RequestMapping("Say-Hello")
	@ResponseBody
	public String sayhello() {
		return "Hey there, Shrunal is here!";
	}
	
	@RequestMapping("Say-Hello-Html")
	@ResponseBody
	public String sayhelloHtml() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<title> HTML Code </title>");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("Hey there, Shrunal-Html is here!");
		buffer.append("</body>");
		buffer.append("</html>");
		
		return buffer.toString();
	}
	
	@RequestMapping("say-Hello-Jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
	@RequestMapping("say-Hello-Jsp01")
	public String sayHelloJsp01() {
		return "index";
	}
}
