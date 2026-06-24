package com.quizApp.microservice.Controller;

import com.quizApp.microservice.Model.Question;
import com.quizApp.microservice.Model.QuestionWrapper;
import com.quizApp.microservice.Model.Response;
import com.quizApp.microservice.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numQ , @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getQuizResult(@PathVariable Integer id , @RequestBody List<Response> responses){
        return quizService.getQuizResult(id,responses);
    }

}
