package bdbt_proj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {
	@RequestMapping("/login")
	public String logowanie() {
		return "login";
	}

	@RequestMapping("/wylogowanie")
	public String wylogowanie() {
		return "login";
	}

	@RequestMapping("/login?error=true")
	public String bladLogowania() {
		return "login_retry";
	}
}
