package com.example.openhouse.repo;

import com.example.openhouse.models.Action;
import com.example.openhouse.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ActionRepository extends CrudRepository<Action, Long> {

}
