package cc.pinyougou.sellergoods.service;

import cc.pinyougou.entity.PageResult;
import cc.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * Created by myvisi on 2018/4/23.
 */
public interface BrandService {
    public List<TbBrand> findAll();

    public PageResult findPage(int pageNum, int pageSize);

    public int add(TbBrand tbBrand);

    public TbBrand findOne(Long id);

    public void  update(TbBrand tbBrand);

    public  void  delete(Long[] ids);

    public PageResult findPage(TbBrand tbBrand,int pageNum,int pageSize);
}
