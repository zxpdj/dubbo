package com.zhang.dubbo.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements  UserService{
//    @Autowired
//    private UserDao userDao;
    public String index(String name) {
        System.out.println("this is provider");
        return "this is provider";
    }
}
