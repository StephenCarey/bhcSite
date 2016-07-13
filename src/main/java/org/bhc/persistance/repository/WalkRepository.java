package org.bhc.persistance.repository;

import org.bhc.persistance.models.Walk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface  WalkRepository  extends JpaRepository<Walk, Long> {

    List<Walk> findByName(String name);

}

