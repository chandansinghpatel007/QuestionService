package com.question.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	// Create
	@PostMapping
	private Question creQuestion(@RequestBody Question question) {
		return questionService.createQuestion(question);
	}
	
	// Get list
	@GetMapping
	private List<Question> getQuestions(){
		return questionService.getQuestions();
	}
	
	// GetOne 
	@GetMapping("/{id}")
	private Question getQuestion(@PathVariable Long id){
		return questionService.getOne(id);
	}
	
	// Get all Question of specific Quiz
	@GetMapping("/quiz/{quizId}")
	private List<Question> getQuestionOfQuiz(@PathVariable Long quizId){
		return questionService.getQuestionsOfQuiz(quizId);
	}
}
