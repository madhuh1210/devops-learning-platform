package com.yourorg.devopslearning.evaluationapi.repository;

import com.yourorg.devopslearning.evaluationapi.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
