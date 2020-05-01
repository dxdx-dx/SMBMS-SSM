package cn.bdqn.smbms.dao;

import cn.bdqn.smbms.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单持久层
 *
 * @author Matrix
 * @date 2020/4/29 20:09
 */
public interface BillMapper {
    //分页查询订单列表
    List<Bill> findByPage(@Param("productName") String productName, @Param("providerId") Integer providerId,
                          @Param("isPayment") Integer isPayment, @Param("pageNo") Integer pageNo,
                          @Param("pageSize") Integer pageSize);

    //查询订单总条数
    int findByPageCount(@Param("productName") String productName, @Param("providerId") Integer providerId,
                        @Param("isPayment") Integer isPayment);

    //根据id查询订单
    Bill findBillById(@Param("id") Integer id);

    //删除订单
    int delbill(@Param("id") Integer id);

    //修改订单
    int billModify(Bill bill);

    //添加订单
    int addBill(Bill bill);
}
