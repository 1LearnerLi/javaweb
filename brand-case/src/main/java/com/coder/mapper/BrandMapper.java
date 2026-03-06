package com.coder.mapper;

import com.coder.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand (brand_name, company_name, ordered, description, status) values (#{brandName},#{companyName},#{ordered},#{description},#{status});")
    void addBrand(Brand brand);
    
    void updateBrand(Brand brand);

    @Delete("delete from tb_brand where id=#{id};")
    void deleteBrand(Integer id);

    void deleteBrands(@Param("ids") int[] ids);

    @Select("select * from tb_brand limit #{begin},#{size};")
    @ResultMap("brandResultMap")
    List<Brand> selectBrandByPage(@Param("begin") int begin, @Param("size")int size);

    @Select("select count(*) from tb_brand;")
    int selectTotalCount();

    List<Brand> selectBrandByPageAndCondition(@Param("begin") int begin, @Param("size") int size,@Param("brand") Brand brand);

    int selectTotalCountByCondition(Brand brand);


}
