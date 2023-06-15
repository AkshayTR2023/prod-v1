package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdController {
	@Autowired
	ProdDAO dao;

	@RequestMapping("/")
	public ModelAndView basePage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView addProd(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		product.setProdName(request.getParameter("name"));
		product.setProdCost(Double.parseDouble(request.getParameter("cost")));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(request.getParameter("dt"));

		product.setOrderDate(date);

		if (dao.addProd(product) != null) {
			modelAndView.setViewName("success");
		}
		return modelAndView;
	}

	@RequestMapping("/view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		List<Product> list = dao.getAllProd();
		modelAndView.setViewName("display");
		modelAndView.addObject("list", list);

		return modelAndView;
	}

	@RequestMapping("/getforedit")
	public ModelAndView getForEdit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		int ID = Integer.parseInt(request.getParameter("id"));
		Product prod = dao.getProd(ID);
		modelAndView.setViewName("editProd");
		modelAndView.addObject("prod", prod);
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView editProd(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		product.setProdID(Integer.parseInt(request.getParameter("id")));
		product.setProdName(request.getParameter("name"));
		product.setProdCost(Double.parseDouble(request.getParameter("cost")));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(request.getParameter("dt"));

		product.setOrderDate(date);
		if (dao.editProd(product) != null) {
			modelAndView.setViewName("redirect:/view");
		}

		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView delProd(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		int ID = (Integer.parseInt(request.getParameter("id")));
		dao.delProd(ID);
		modelAndView.setViewName("redirect:/view");

		return modelAndView;
	}

}
