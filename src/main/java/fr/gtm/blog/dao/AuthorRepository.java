package fr.gtm.blog.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.blog.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	@Transactional
	Author findByName(final String name);
}
