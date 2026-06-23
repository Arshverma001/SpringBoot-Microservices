package com.quizApp.microservice.Repo;

import com.quizApp.microservice.Model.Question;
import com.quizApp.microservice.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
