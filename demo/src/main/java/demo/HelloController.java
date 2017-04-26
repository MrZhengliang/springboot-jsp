package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by xx on 2017/4/26.
 */
@Controller
public class HelloController {

    @Value("${application.hello:Hello Angel}")
    private String hello;

    @RequestMapping("/he")
    public String say(Map<String,Object> map){
        map.put("hello",hello);
        return "hello";
    }
}
