package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(Model model)
    {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

   @GetMapping("hello-mvc")
   public String helloMvc(@RequestParam("name") String name, Model model)
   {
       model.addAttribute("name", name);
       return "hello-templete";


   }

//    데이터를 내놓는 방식 (키 : 벨류로 이루어진 JSON 방식)
    @GetMapping("hello-json")
    @ResponseBody // HTML 구조중 Body에 데이터를 직접 넣어주겠다.를 의미
    public Hello HelloJson(@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(25);
        return hello;
    }

    static class Hello
    {

        private String name;
        private int age;

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
