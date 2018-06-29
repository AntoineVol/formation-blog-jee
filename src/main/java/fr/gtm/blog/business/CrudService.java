package fr.gtm.blog.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.blog.domain.Entity;

public abstract class CrudService<ENTITY extends Entity> {

	@Autowired
	protected JpaRepository<ENTITY,Integer> repo;

	public CrudService() {
		super();
	}

	protected ENTITY save(ENTITY entity) {
		return this.repo.save(entity);
	}

	public ENTITY create(ENTITY entity) {
		return this.save(entity);
	}

	public List<ENTITY> getList() {
		return this.repo.findAll();
	}

	public void delete(Integer id) {
		this.repo.deleteById(id);
		;
	}

	public ENTITY edit(ENTITY entity) {
		if (entity.getId() == null) {
			throw new IllegalArgumentException(
					"Cannot update an article without its id.");
		}
		return this.save(entity);
	}



}