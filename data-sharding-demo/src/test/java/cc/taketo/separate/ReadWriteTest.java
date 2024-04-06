package cc.taketo.separate;

import cc.taketo.DataShardingApplication;
import cc.taketo.entity.User;
import cc.taketo.mapper.UserMapper;
import cn.hutool.core.date.DatePattern;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Zhangp
 * @date 2024/3/10 18:58
 */
@SpringBootTest(classes = DataShardingApplication.class)
public class ReadWriteTest {

    @Resource
    private UserMapper userMapper;

    private final DateTimeFormatter dateTemplate = DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN);

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setCreateTime(LocalDateTime.parse(LocalDateTime.now().format(dateTemplate), dateTemplate));

        userMapper.insert(user);
    }

    @Test
    public void testSelect() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    @Transactional
    public void testTrans() {
        User user = new User();
        user.setUsername("lisi");
        user.setCreateTime(LocalDateTime.parse(LocalDateTime.now().format(dateTemplate), dateTemplate));
        userMapper.insert(user);

        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
