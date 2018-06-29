package fr.gtm.blog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.blog.business.CrudService;
import fr.gtm.blog.domain.Article;

public class DeleteServlet extends AutowiredServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CrudService<Article> service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final String strId = req.getParameter("id");
		service.delete(Integer.parseInt(strId));
		resp.sendRedirect(
				this.getServletContext().getContextPath() + "/articles");
	}
}
