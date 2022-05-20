package uk.co.rpl.exampleapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api
public class HomeController {
    @GetMapping("/")
    @ApiOperation("Invoke swagger")
    public String start(){
        return "redirect:swagger-ui/";
    }
}
