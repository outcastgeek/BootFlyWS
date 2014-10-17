package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by outcastgeek on 10/16/2014.
 */
@Controller
public class SampleController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("greeting", "Hello World!");
        return "hello";
    }
}
