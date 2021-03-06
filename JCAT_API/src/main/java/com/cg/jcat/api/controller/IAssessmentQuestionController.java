package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jcat.api.dao.AssessmentQuestionModel;
import com.cg.jcat.api.entity.AssessmentQuestion;

@RestController
@RequestMapping("/assessmentQuestion")
public interface IAssessmentQuestionController {

	@GetMapping("/getAll")
	public List<AssessmentQuestion> getQuestions();

	@GetMapping("/get/question/{questionId}")
	public AssessmentQuestionModel getQuestionById(@PathVariable int questionId);

	@PostMapping("/createQuestion")
	public void saveQuestions(@RequestBody AssessmentQuestionModel question);

	@PutMapping("/updateQuestion")
	public void updateQuestion(@RequestBody AssessmentQuestionModel question);

	@DeleteMapping("/deleteQuestion/{questionId}")
	public void deleteQuestion(@PathVariable int questionId);

}
