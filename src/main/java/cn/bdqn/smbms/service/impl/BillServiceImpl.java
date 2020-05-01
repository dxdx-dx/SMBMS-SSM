package cn.bdqn.smbms.service.impl;

import cn.bdqn.smbms.dao.BillMapper;
import cn.bdqn.smbms.pojo.Bill;
import cn.bdqn.smbms.service.BillService;
import cn.bdqn.smbms.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单业务逻辑层实现类
 */
@Service
public class BillServiceImpl implements BillService {
    @Resource
    private BillMapper billMapper;//订单dao层对象

    /**
     * 分页查询订单列表
     *
     * @return java.util.List<cn.bdqn.smbms.pojo.Bill>
     * @author Matrix
     * @date 2020/4/26 23:08
     */
    @Override
    public List<Bill> findByPage(String productName, Integer providerId, Integer isPayment, Integer pageNo, Integer pageSize) {
        List<Bill> billList = null;
        billList = billMapper.findByPage(productName, providerId, isPayment, (pageNo - 1) * Constants.PAGE_SIZE, pageSize);
        return billList;
    }

    /**
     * 查询订单总条数
     *
     * @return int
     * @author Matrix
     * @date 2020/4/26 23:09
     */
    @Override
    public int findByPageCount(String productName, Integer providerId, Integer isPayment) {
        int result = 0;
        result = billMapper.findByPageCount(productName, providerId, isPayment);
        return result;
    }

    /**
     * 根据id查询订单
     *
     * @return cn.bdqn.smbms.pojo.Bill
     * @author Matrix
     * @date 2020/4/26 23:10
     */
    @Override
    public Bill findBillById(Integer id) {
        Bill bill = null;
        bill = billMapper.findBillById(id);
        return bill;
    }

    /**
     * 删除订单
     *
     * @return boolean
     * @author Matrix
     * @date 2020/4/26 23:55
     */
    @Override
    public boolean delbill(Integer id) {
        boolean result = false;
        int res = 0;
        res = billMapper.delbill(id);
        if (res > 0) result = true;
        return result;
    }

    /**
     * 修改订单
     *
     * @return boolean
     * @author Matrix
     * @date 2020/4/27 0:12
     */
    @Override
    public boolean billModify(Bill bill) {
        boolean result = false;
        int res = 0;
        res = billMapper.billModify(bill);
        if (res > 0) result = true;
        return result;
    }

    /**
     * 添加订单
     *
     * @return boolean
     * @author Matrix
     * @date 2020/4/27 0:13
     */
    @Override
    public boolean addBill(Bill bill) {
        boolean result = false;
        int res = 0;
        res = billMapper.addBill(bill);
        if (res > 0) result = true;
        return result;
    }

}
