package fr.gtm.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.blog.business.ArticleService;
import fr.gtm.blog.domain.Article;

@Controller
public class IndexController {
	
	@Autowired
	ArticleService service;
	
	@RequestMapping({"/index", "/articles"})
	public ModelAndView article() {
		final ModelAndView mav = new ModelAndView("index");
		mav.addObject("listArticle", this.service.getList());
		return mav ;
	}
	
	@RequestMapping("/manage")
	public ModelAndView manage () {	
		final ModelAndView mav = new ModelAndView("article");
		return mav ;
	}
	
	@PostMapping("/manage")
	public ModelAndView submit(@RequestParam String title , @RequestParam ("descr") String content) {
		Article entity = new Article();
		entity.setTitle(title);
		entity.setDescription(content);;
		this.service.create(entity);
		return article();
	}
}
