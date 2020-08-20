package fudan.leon.mpadvanced.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: liyang27
 * @Date: 2020/6/21 19:54
 * @Description:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        boolean hasSetter = metaObject.hasSetter("createTime1");
        if (hasSetter) {
            setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //如果自己设置了值，就不会选择自动填充了
        Object val = getFieldValByName("updateTime", metaObject);
        if (val == null) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }
}
