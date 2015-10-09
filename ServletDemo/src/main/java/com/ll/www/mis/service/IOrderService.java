package com.ll.www.mis.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IOrderService {
	
   public void SelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
     
   public void SelectByPar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   
   public void Save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   
   public void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   
   public void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
