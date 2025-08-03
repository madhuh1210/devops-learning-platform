package com.yourorg.devopslearning.evaluationapi.controller;

import com.yourorg.devopslearning.evaluationapi.model.Evaluation;
import com.yourorg.devopslearning.evaluationapi.service.EvaluationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping
    public ResponseEntity<List<Evaluation>> getAllEvaluations() {
        return new ResponseEntity<>(evaluationService.getAllEvaluations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable Long id) {
        Evaluation evaluation = evaluationService.getEvaluationById(id);
        if (evaluation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(evaluation);
    }

    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation saved = evaluationService.saveEvaluation(evaluation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable Long id, @RequestBody Evaluation evaluation) {
        Evaluation existing = evaluationService.getEvaluationById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setCandidateName(evaluation.getCandidateName());
        existing.setTestName(evaluation.getTestName());
        existing.setScore(evaluation.getScore());
        existing.setCompletedAt(evaluation.getCompletedAt());
        Evaluation updated = evaluationService.saveEvaluation(existing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        Evaluation existing = evaluationService.getEvaluationById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        evaluationService.deleteEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
