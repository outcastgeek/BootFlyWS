package hello

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by outcastgeek on 10/17/2014.
 */
@Controller
class HelloController {

    @RequestMapping("/hello/{name}")
    String greet(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name)
        "greet"
    }
}
