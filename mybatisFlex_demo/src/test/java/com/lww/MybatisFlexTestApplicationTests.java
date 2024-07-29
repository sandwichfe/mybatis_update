package com.lww;


import com.lww.entity.Account;
import com.lww.mapper.AccountMapper;
import com.mybatisflex.core.query.If;
import com.mybatisflex.core.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.lww.entity.table.AccountTableDef.ACCOUNT;


@SpringBootTest
class MybatisFlexTestApplicationTests {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    void contextLoads() {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(ACCOUNT.AGE.eq(18));
        Account account = accountMapper.selectOneByQuery(queryWrapper);
        System.out.println(account);
    }

    @Test
    void testInsert() {
        Account account = new Account();
        account.setAge(18);
        account.setUserName("1234");
        accountMapper.insert(account);
    }

    @Test
    void testInsertSelective() {
        Account account = new Account();
        account.setAge(18);
        account.setUserName("1234");
        accountMapper.insertSelective(account);
    }

    @Test
    void testUpdate() {
        Account account = new Account();
        account.setAge(18);
        account.setUserName("1234");
        accountMapper.update(account);
    }


    @Test
    void testDeleteById() {
        Account account = new Account();
        account.setAge(18);
        account.setUserName("1234");
        accountMapper.deleteById(1);
    }

    @Test
    void testDelete() {
        Account account = new Account();
        account.setAge(18);
        account.setUserName("1234");
        accountMapper.delete(account);
    }

    @Test
    void testSelectByQuery() {
//        QueryWrapper queryWrapper = QueryWrapper.create();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(ACCOUNT.ID,ACCOUNT.AGE).from(ACCOUNT);

        queryWrapper.where(ACCOUNT.USER_NAME.ge("老王"))
                .and(ACCOUNT.ID.eq(1));
        List<Account> accounts = accountMapper.selectListByQuery(queryWrapper);
        accounts.forEach(System.out::println);
    }

    @Test
    void testSelectByQueryLambda() {
        boolean flag = false;
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select().from(ACCOUNT)
                .where(ACCOUNT.ID.ge(100,flag)) //flag为false，忽略该条件
                .and(ACCOUNT.USER_NAME.likeLeft("michael"));


        List<Account> accounts = accountMapper.selectListByQuery(queryWrapper);
        accounts.forEach(System.out::println);
    }






}
