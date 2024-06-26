package com.question.services;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {
	//Add
	Question createQuestion(Question question);
	
	//Get
	List<Question> getQuestions();
	
	//Get Single
	Question getOne(Long id); 
	
	// Get Question by Quiz ID
	List<Question> getQuestionsOfQuiz(Long quizId);
}
