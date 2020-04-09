package com.study.springboot.web;

import com.study.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        //PostsResponseDto dto = postsService.findById(id); -> 이렇게 했을 시 post 변수에 값이 안들어가는 것 같음 / mustache not method or filed
        //model.addAttribute("post", dto);
        model.addAttribute("post", postsService.findById(id));

        return "posts-update";
    }
}
