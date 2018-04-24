package cc.pinyougou.mapper;

import cc.pinyougou.pojo.TbAddress;
import cc.pinyougou.pojo.TbAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAddressMapper {
    int countByExample(TbAddressExample example);

    int deleteByExample(TbAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    List<TbAddress> selectByExample(TbAddressExample example);

    TbAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param(value = "record") TbAddress record, @Param(value = "example") TbAddressExample example);

    int updateByExample(@Param(value = "record") TbAddress record, @Param(value = "example") TbAddressExample example);

    int updateByPrimaryKeySelective(TbAddress record);

    int updateByPrimaryKey(TbAddress record);
}