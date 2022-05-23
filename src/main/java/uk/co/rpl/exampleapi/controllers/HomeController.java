package uk.co.rpl.exampleapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api
@Slf4j
public class HomeController {
    @GetMapping("/")
    @ApiOperation("Invoke swagger")
    public String start(){
        log.info("Calling swagger");
        return "redirect:swagger-ui/";
    }
}
