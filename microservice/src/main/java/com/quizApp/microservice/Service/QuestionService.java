package com.quizApp.microservice.Service;

import com.quizApp.microservice.Model.Question;
import com.quizApp.microservice.Repo.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return  new ResponseEntity<>(questionDao.findQuestionsByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<String> addQuestion(Question question) {
        Question save = questionDao.save(question);
        if (save != null) {
            return new ResponseEntity<>("Question added successfully",HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add question",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        if(questionDao.existsById(id)){
            questionDao.deleteById(id);
            return new ResponseEntity<>("Question deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Question not found",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        if (questionDao.existsById(question.getId())) {
            questionDao.save(question);
            return new ResponseEntity<>("Question updated successfully",HttpStatus.OK);
        }

        return new ResponseEntity<>("Question not found",HttpStatus.BAD_REQUEST);
    }
}