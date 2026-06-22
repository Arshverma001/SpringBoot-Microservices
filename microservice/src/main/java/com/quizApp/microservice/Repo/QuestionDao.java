package com.quizApp.microservice.Repo;

import com.quizApp.microservice.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findQuestionsByCategory(String category);
}
