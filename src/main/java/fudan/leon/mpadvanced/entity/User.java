package fudan.leon.mpadvanced.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @Author: liyang27
 * @Date: 2020/6/21 16:54
 * @Description:
 */
@Data
@TableName("user2")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    @Version
    private Integer version;
    @TableLogic
    @TableField(select = false)
    private Integer deleted;
}
