package cn.bdqn.smbms.dao;

import cn.bdqn.smbms.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 供应商持久层
 *
 * @author Matrix
 * @date 2020/4/29 20:10
 */
public interface ProviderMapper {
    //分页查询供应商列表
    List<Provider> findByPage(@Param("proCode") String proCode, @Param("proName") String proName,
                              @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    //查询供应商总条数
    int findByPageCount(@Param("proCode") String proCode, @Param("proName") String proName);

    //查询所有供应商名称
    List<Provider> findName();

    //添加供应商
    int addPrivider(Provider provider);

    //根据id查询供应商
    Provider findProviderById(@Param("id") Integer id);

    //修改供应商
    int providerModify(Provider provider);

    //删除供应商
    int delprovider(@Param("id") Integer id);

}
