package com.lww;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lww.entity.User;
import com.lww.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(null);
        user.setName("test111");
        user.setEmail("123@123.qq");
        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setAge(null);
        user.setName("test111");
        user.setEmail("123@123.qq");
        userMapper.updateById(user);
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setAge(null);
        user.setName("test111");
        user.setEmail("123@123.qq");
        userMapper.deleteById(user);
    }

    @Test
    public void testSelectQuery() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        LambdaQueryWrapper<User> lambda = queryWrapper.lambda();
        lambda.eq(User::getName,"test111");
        lambda.select(User::getId,User::getName);


        List<User> userList = userMapper.selectList(lambda);
        userList.forEach(System.out::println);

    }



}
