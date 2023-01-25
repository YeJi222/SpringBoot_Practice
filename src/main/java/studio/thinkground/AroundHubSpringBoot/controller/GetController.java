package studio.thinkground.AroundHubSpringBoot.controller;

import org.springframework.web.bind.annotation.*;
import studio.thinkground.AroundHubSpringBoot.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World!";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        return "YeJi";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable String var){
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?
    // name=YeJi&
    // email=thinkground.21900806@handong.ac.kr&
    // organization=thinkground
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // 어떤 값이 들어올지 예측이 안되는 경우
    // http://localhost:8080/api/v1/get-api/request2?key1=value&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request2?name=YeJi?email=21900806@handong.ac.kr&organization=thinkground
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        // return memberDTO.getName() + " " + memberDTO.getEmail() + " " + memberDTO.getOrganization()
        return memberDTO.toString();
    }
}
