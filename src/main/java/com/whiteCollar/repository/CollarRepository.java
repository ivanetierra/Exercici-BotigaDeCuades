package com.whiteCollar.repository;

import com.whiteCollar.model.Collar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollarRepository extends JpaRepository<Collar, Long> {
}
