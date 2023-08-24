package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import io.datajek.spring.basics.movierecommendersystem.lesson1.RecommenderImplementation;
import io.datajek.spring.basics.movierecommendersystem.lesson8.Movie;


@SpringBootApplication
@ComponentScan(includeFilters = @ComponentScan.Filter (
                    type= FilterType.REGEX, 
                    pattern="io.datajek.spring.basics.movierecommendersystem.lesson*"))
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(
                MovieRecommenderSystemApplication.class, args);

//Retrieving singleton bean from application context
RecommenderImplementation recommender = appContext.getBean(
                              RecommenderImplementation.class);   
System.out.println(recommender);

//Retrieving prototype bean from application context twice
Movie m1 = appContext.getBean(Movie.class);
System.out.println(m1);

Movie m2 = appContext.getBean(Movie.class);
System.out.println(m2);
	}

}
