package com.supercopo.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.supercopo.model.Ramoatividade;

public class Ramoatividades implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Ramoatividades() {

	}

	public Ramoatividades(EntityManager manager) {
		this.manager = manager;
	}

	public List<Ramoatividade> pesquisar(String descricao) {

		CriteriaBuilder criterBuilder = manager.getCriteriaBuilder();

		CriteriaQuery<Ramoatividade> criteriaQuery = criterBuilder.createQuery(Ramoatividade.class);
		Root<Ramoatividade> ramoatividadrRoot = criteriaQuery.from(Ramoatividade.class);
		criteriaQuery.select(ramoatividadrRoot);
		criteriaQuery.where(criterBuilder.like(ramoatividadrRoot.get("descricao"), descricao + "%"));

		TypedQuery<Ramoatividade> query = manager.createQuery(criteriaQuery);

		return query.getResultList();
	}

}
