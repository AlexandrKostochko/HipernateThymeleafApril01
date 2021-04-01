package by.tms.controller;

import by.tms.dao.UserDao;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/user")
    public ModelAndView saveGet(User user, ModelAndView modelAndView) {
        modelAndView.setViewName("save");
        return modelAndView;
    }

    @PostMapping(path = "/user")
    public ModelAndView savePost(User user, ModelAndView modelAndView) {
        userDao.save(user);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("save");
        return modelAndView;
    }

    @GetMapping(path = "/allInfo")
    public ModelAndView getAllUsers(ModelAndView modelAndView) {
        modelAndView.addObject("info", userDao.getAllUsers());
        modelAndView.setViewName("allInfo");
        return modelAndView;
    }
}
