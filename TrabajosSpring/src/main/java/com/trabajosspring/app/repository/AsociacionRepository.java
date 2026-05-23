package com.trabajosspring.app.repository;

import com.trabajosspring.app.entity.Asociacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsociacionRepository extends JpaRepository<Asociacion, Long> {
}