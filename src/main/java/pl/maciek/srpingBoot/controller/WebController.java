package pl.maciek.srpingBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.maciek.srpingBoot.model.Article;

/**
 * Created by macie on 26.08.2017.
 */
@Controller
public class WebController  {

//
//    @GetMapping("/")
//    public String hello(){
//        return "hello";
//    }
//
//    String name = "maciek";
//
//    @ResponseBody
//    @GetMapping("/hello")
//    public String helloname(){
//        return "HELLLLLO" + name;
//    }

    @GetMapping("/add")
    public String add() {
        return "article/add";
    }

    @GetMapping("/show")
    public String show(@ModelAttribute Article article, ModelMap modelMap){
        modelMap.addAttribute("article", article);
        return "article/show";
    }
}
