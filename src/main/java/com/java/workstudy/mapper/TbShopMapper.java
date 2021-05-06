package com.java.workstudy.mapper;

import com.java.workstudy.pojo.TbShop;

public interface TbShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbShop record);

    int insertSelective(TbShop record);

    TbShop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbShop record);

    int updateByPrimaryKey(TbShop record);
}