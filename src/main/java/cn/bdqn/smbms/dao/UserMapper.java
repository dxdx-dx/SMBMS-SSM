package cn.bdqn.smbms.dao;

import cn.bdqn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户数据访问层
 *
 * @author Matrix
 * @date 2020/4/28 20:59
 */
public interface UserMapper {
    //根据UserCode查询用户
    List<User> findByUserCode(@Param("userCode") String userCode);

    //分页查询用户列表
    List<User> findByPage(@Param("userName") String userName, @Param("userRole") Integer userRole,
                          @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    //查询用户总条数
    int findByPageCount(@Param("userName") String userName, @Param("userRole") Integer userRole);

    //添加用户
    int adduser(User user);

    //根据id查询用户
    User findUserById(@Param("id") Integer id);

    //修改用户
    int modifyUser(User user);

    //删除用户
    int deluser(@Param("id") Integer id);

    //根据id修改密码
    int modifyPwd(@Param("id") Integer id, @Param("newPwd") String newPwd);
}
