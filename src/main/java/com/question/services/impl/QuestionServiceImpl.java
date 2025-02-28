package com.question.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	private QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	@Override
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question getOne(Long id) {
		return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
		return questionRepository.findByQuizId(quizId);
	}

}
