package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class RecommenderImplementation {

	// use filter interface to select filter
	@Autowired
	@Qualifier("CF")
	private Filter filter;
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());

	 @Autowired
	 public void setFilter(Filter filter) {
	  logger.info("In RecommenderImplementation setter method..dependency injection");
	     this.filter = filter;
	   }

	public String[] recommendMovies(String movie) {

		
		
		// print the name of interface implementation being used
		System.out.println("Name of the filter in use: " + filter + "\n");

		String[] results = filter.getRecommendations(movie);
		// return the results
		return results;
	}
	
	@PostConstruct
    public void postConstruct() {
        //initialization code goes here
        logger.info("In RecommenderImplementation postConstruct method");
    }
	
	@PreDestroy
	 public void preDestroy() {
        //cleanup code
        logger.info("In RecommenderImplementation preDestroy method");
    }
}
