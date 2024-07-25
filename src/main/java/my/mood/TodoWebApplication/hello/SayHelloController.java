package my.mood.TodoWebApplication.hello;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

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
	
	// private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("say-Hello-Jsp")
	public String sayHelloJsp(@RequestParam String name, ModelMap newModel) {
		
		// level of logging 
//		logger.debug("Request Param is {} at Debug level", name);
//		logger.info("Request Param at Info level");
//		logger.warn("Request Param at Warn level");
		
		newModel.put("name", name);
		return "sayHello";
	}
	
	@RequestMapping("say-Hello-Jsp01")
	public String sayHelloJsp01(@RequestParam int age, ModelMap newModel01) {
		
		newModel01.put("age", age);
		return "index";
	}
}
