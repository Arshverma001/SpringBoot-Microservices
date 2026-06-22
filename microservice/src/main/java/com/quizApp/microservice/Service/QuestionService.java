package com.quizApp.microservice.Service;

import com.quizApp.microservice.Controller.Question;
import com.quizApp.microservice.Repo.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findQuestionsByCategory(category);
    }


    public String addQuestion(Question question) {
        Question save = questionDao.save(question);
        if (save != null) {
            return "Question added successfully";
        } else {
            return "Failed to add question";
        }
    }
}