package cc.pinyougou.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 三国的包子
 * @version 1.0
 * @description 描述
 * @title 标题
 * @package entity
 * @company www.itheima.com
 */
@Data
public class PageResult implements Serializable {

    private long total;//总记录数

    private List rows;//分页的数据列表集合

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
    public PageResult() {
    }



}
