package fr.gtm.blog.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Author implements Entity, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private LocalDate subDate;
	private Adress adress;
	private List<Article> listArticle;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getSubDate() {
		return subDate;
	}
	public void setSubDate(LocalDate subDate) {
		this.subDate = subDate;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public List<Article> getListArticle() {
		return listArticle;
	}
	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}

	
	
	
	
	
}
