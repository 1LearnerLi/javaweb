package com.coder.service;

import com.coder.pojo.Brand;
import com.coder.pojo.PageBean;

import java.util.List;

public interface BrandService {

    List<Brand> selectAll();

    void addBrand(Brand brand);

    void updateBrand(Brand brand);

    void deleteBrand(Integer id);

    void deleteBrands(int[] ids);

    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    PageBean<Brand> selectByConditionAndCondition(int currentPage, int pageSize,Brand brand);
}
