package com.quizApp.microservice.Service;


import com.quizApp.microservice.Controller.Question;
import com.quizApp.microservice.Repo.QuestionDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
}
