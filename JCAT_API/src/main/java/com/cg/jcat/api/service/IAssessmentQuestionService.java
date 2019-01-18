package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.jcat.api.dao.AssessmentQuestionModel;

@Service
public interface IAssessmentQuestionService {
	

	public List<AssessmentQuestionModel> getQuestions();

	public AssessmentQuestionModel saveQuestions(AssessmentQuestionModel assessmentQuestionModel);

	public AssessmentQuestionModel updateQuestion(AssessmentQuestionModel question);

	public boolean deleteQuestion(int questionId);

	

}
