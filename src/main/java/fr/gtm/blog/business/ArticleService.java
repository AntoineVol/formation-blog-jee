package fr.gtm.blog.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.blog.dao.ArticleRepository;
import fr.gtm.blog.domain.Article;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repo;

	public Article create(final String title, final String description) {
		return this.save(new Article(title, description));
	}

	public List<Article> getArticles() {
		return this.repo.findAll();
	}

	public void delete(int id) {
		this.repo.deleteById(id);
		;
	}

	public Article edit(Article article) {
		if (article.getId() == null) {
			throw new IllegalArgumentException(
					"Cannot update an article without its id.");
		}
		return this.save(article);
	}

	private Article save(Article article) {
		return this.repo.save(article);
	}
}
