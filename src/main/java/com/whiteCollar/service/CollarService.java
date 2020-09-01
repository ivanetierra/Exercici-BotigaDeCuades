package com.whiteCollar.service;

import com.whiteCollar.model.Collar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whiteCollar.repository.CollarRepository;

@Service
public class CollarService {

	@Autowired
	private CollarRepository repo;

	public void save(Collar t) {
		repo.save(t);
	}
}
