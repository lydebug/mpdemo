package fudan.leon.mpadvanced;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import fudan.leon.mpadvanced.dao.UserMapper;
import fudan.leon.mpadvanced.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/6/21 19:18
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestLogic {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setAge(18);
        user.setId(6L);
        userMapper.insert(user);
    }

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(6);
        System.out.println("rows = " + rows);
    }

    @Test
    public void select() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void mySelect() {
        List<User> users = userMapper.mySelectList(Wrappers.<User>lambdaQuery()
                .gt(User::getAge, 10).eq(User::getDeleted, 0));
        users.forEach(System.out::println);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(5L);
        user.setAge(37);
        userMapper.updateById(user);
    }

    @Test
    public void testoptlock() {
        User u = new User();
        u.setId(5L);
        u.setAge(10);
        u.setVersion(3);
        userMapper.updateById(u);
    }
}
