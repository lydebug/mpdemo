package fudan.leon.mpadvanced.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import fudan.leon.mpadvanced.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/6/21 16:57
 * @Description:
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user2 ${ew.customSqlSegment}")
    List<User> mySelectList(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

}
