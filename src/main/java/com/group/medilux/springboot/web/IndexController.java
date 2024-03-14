package com.group.medilux.springboot.web;
import com.group.medilux.springboot.config.auth.LoginUser;
import com.group.medilux.springboot.config.auth.dto.SessionUser;
import com.group.medilux.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    //처음 화면에 게시글 불러오기 
    @GetMapping("/")
    public String index(Model model ,  @LoginUser SessionUser user) {
        model.addAttribute("posts" , postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    //게시글 등록하기
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    //게시글 수정
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("post" , postsService.findById(id));
        return "posts-update";
    }



}
