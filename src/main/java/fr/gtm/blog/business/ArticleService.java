package fr.gtm.blog.business;

import org.springframework.stereotype.Service;

import fr.gtm.blog.domain.Article;

@Service
public class ArticleService extends CrudService<Article> {
	@Override
	public Article create(Article entity) {
		if (entity.getAuthor() != null && (entity.getAuthor().getId() != null)
				|| entity.getAuthor().getName() != null) {
			return super.create(entity);			
		}else {
			throw new IllegalArgumentException("Impossible de créer un article sans auteur");
		}
	}
}
