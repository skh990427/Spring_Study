package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Spring hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //HTTP에서 바디부에 데이터를 직접 넣어주겠다 라는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //spring이 들어오면 "hello spring"으로 바뀜
    }

    @GetMapping("hello-api") //json 으로 반환 json형태 = Key:Value
    @ResponseBody //객체를 반환하고 @ResponseBody 를 해두면 json으로 반환한다.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();

        hello.setName(name);
        return hello;
    }

    static class Hello { //용어는 프로퍼티 접근방식? 이라고도 함 변수는 private로 선언하고 public 메소드 통해서 접근하는 방식
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
