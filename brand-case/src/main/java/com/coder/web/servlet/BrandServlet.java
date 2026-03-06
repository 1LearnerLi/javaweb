package com.coder.web.servlet;

import com.alibaba.fastjson.JSON;
import com.coder.pojo.Brand;
import com.coder.pojo.PageBean;
import com.coder.service.BrandService;
import com.coder.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);


    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s = req.getReader().readLine();
        Brand brand = JSON.parseObject(s, Brand.class);

        brandService.addBrand(brand);
        resp.getWriter().write("success");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        Brand brand = JSON.parseObject(s, Brand.class);
        System.out.println(brand);
        brandService.updateBrand(brand);
        resp.getWriter().write("success");


    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        System.out.println(s);
        brandService.deleteBrand(Integer.parseInt(s));
        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s = req.getReader().readLine();
        int[] ids = JSON.parseObject(s, int[].class);
        brandService.deleteBrands(ids);
        resp.getWriter().write("success");

    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        PageBean<Brand> brandPageBean = brandService.selectByPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));

        String jsonString = JSON.toJSONString(brandPageBean);


        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);


    }

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        String s = req.getReader().readLine();
        Brand brand = JSON.parseObject(s, Brand.class);

        PageBean<Brand> brandPageBean = brandService.selectByConditionAndCondition(Integer.parseInt(currentPage), Integer.parseInt(pageSize), brand);

        String jsonString = JSON.toJSONString(brandPageBean);



        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);


    }


}
